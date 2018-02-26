package com.learn.chapter8.dao;

import com.learn.chapter8.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzy
 * <p>
 * Create Time: 18-2-26 下午2:31
 * @version v1.00
 */
@Repository
public interface UserDAO {
    User getUser(Long id);

    List<User> findUser(String userName);

    int updateUser(User user);

    int insertUser(User user);

    int deleteUser(Long id);
}
