package com.learn.chapter8.app;

import com.learn.chapter8.dao.UserDAO;
import com.learn.chapter8.po.User;
import com.learn.chapter8.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author lzy
 * <p>
 * Create Time: 18-2-26 下午3:55
 * @version v1.00
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
        UserDAO dao = ctx.getBean(UserDAO.class);
        User user = new User();
        user.setCnname("test");
        user.setEmail("test@123");
        user.setMobile("123455");
        user.setSex((short) 0);
        user.setUserName("testUser");
        user.setNote("note for tester");
        logger.info("" + dao.insertUser(user));

        List<User> users = dao.findUser("t");
        for (User u : users) {
            logger.info(u.getEmail());
        }

        dao.deleteUser(13L);

        UserService userService = ctx.getBean(UserService.class);
        List<User> userList = userService.getUserList("te");
        logger.info("" + userList.size());
    }
}
