package com.learn.chapter9.app;

import com.learn.chapter2.util.SqlSessionFactoryUtil;
import com.learn.chapter8.po.User;
import com.learn.chapter9.dao.UserDAO;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lzy
 * @create 2018-02-27 下午2:59
 */
public class App3 {
    private static final Logger logger = LoggerFactory.getLogger(App3.class);

    public static void main(String[] args) {
        SqlSession session = SqlSessionFactoryUtil.openSqlSession();
        UserDAO dao = session.getMapper(UserDAO.class);
        List<User> userList = dao.findUsersByName("te", new RowBounds(0, 5));
        for (User user : userList) {
            logger.info("userNum:{} userName:{}", user.getId(), user.getUserName());
        }
    }
}
