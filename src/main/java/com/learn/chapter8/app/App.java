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
        for (int i = 0; i < 5; i++) {
            logger.info("-------- " + i + " ---------");
            UserDAO dao = ctx.getBean(UserDAO.class);
            User user = new User();
            user.setCnname("test");
            user.setEmail("test@123");
            user.setMobile("123455");
            user.setSex((short) 0);
            user.setUserName("testUser");
            user.setNote("note for tester");
            dao.insertUser(user);
            logger.info("[Insert Num]: " + user.getId());
            List<User> users = dao.findUser("t");
            for (User u : users) {
                logger.info(u.getEmail());
            }

            dao.deleteUser(user.getId());

            UserService userService = ctx.getBean(UserService.class);
            List<User> userList = userService.getUserList("te");
            logger.info("" + userList.size());

            UserDAO dao1 = ctx.getBean(UserDAO.class);
            User user1 = dao1.getUser(1L);
            logger.info("[dao1]:" + user.getUserName());
        }
    }
}
