package com.learn.chapter8.service;

import com.learn.chapter8.dao.UserDAO;
import com.learn.chapter8.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lzy
 * <p>
 * Create Time: 18-2-26 下午5:16
 * @version v1.00
 */
@Service
public class UserService {
    private final UserDAO dao;

    @Autowired
    public UserService(UserDAO dao) {
        this.dao = dao;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public List<User> getUserList(String name) {
        return dao.findUser(name);
    }
}
