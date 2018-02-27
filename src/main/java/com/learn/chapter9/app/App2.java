package com.learn.chapter9.app;

import com.learn.chapter2.util.SqlSessionFactoryUtil;
import com.learn.chapter9.dao.ProcedureMapper;
import com.learn.chapter9.pojo.ProcedurePojo;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lzy
 * @create 2018-02-27 上午11:24
 */
public class App2 {
    private static final Logger logger = LoggerFactory.getLogger(App2.class);

    public static void main(String[] args) {
        SqlSession session = SqlSessionFactoryUtil.openSqlSession();
        ProcedureMapper procedureMapper = session.getMapper(ProcedureMapper.class);
        ProcedurePojo pojo = new ProcedurePojo();
        pojo.setUserName("test");
        procedureMapper.count(pojo);
        logger.info(pojo.getUserName() + "\t" + pojo.getResult() + "\t");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        logger.info("execute:" + dateFormat.format(pojo.getExecDate()));
    }
}
