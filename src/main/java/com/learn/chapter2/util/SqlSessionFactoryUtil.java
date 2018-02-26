package com.learn.chapter2.util;

import com.learn.chapter2.main.App;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lzy
 * <p>
 * Create Time: 2018/2/2 12:32
 * @version v1.00
 */
public class SqlSessionFactoryUtil {
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    /**
     * SqlSessioinFactory对象
     */
    private static SqlSessionFactory sqlSessionFactory = null;
    // 类线程锁
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    private SqlSessionFactoryUtil() {
    }

    /**
     * 构建SqlSessionFactory
     *
     * @return
     */
    public static SqlSessionFactory initSqlSesionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            logger.error("[SqlSessionFactoryUtil]", e);
        }
        synchronized (CLASS_LOCK) {
            if (null == sqlSessionFactory) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 打开SqlSession
     */
    public static SqlSession openSqlSession() {
        if (null == sqlSessionFactory) {
            initSqlSesionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
