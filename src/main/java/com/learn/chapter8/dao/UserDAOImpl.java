package com.learn.chapter8.dao;

import com.learn.chapter8.po.User;

import java.util.List;

/**
 * @author lzy
 * <p>
 * Create Time: 18-2-26 下午3:09
 * @version v1.00
 */
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
    @Override
    public User getUser(Long id) {
        return (User) this.getSqlSessionTemplate().selectOne("com.learn.chapter8.dao.UserDAO.getUser", id);
    }

    @Override
    public List<User> findUser(String userName) {
        return this.getSqlSessionTemplate().selectList("com.learn.chapter8.dao.UserDAO.findUser", userName);
    }

    @Override
    public int updateUser(User user) {
        return this.getSqlSessionTemplate().update("com.learn.chapter8.dao.UserDAO.updateUser", user);
    }

    @Override
    public int insertUser(User user) {
        return this.getSqlSessionTemplate().insert("com.learn.chapter8.dao.UserDAO.insertUser", user);
    }

    @Override
    public int deleteUser(Long id) {
        return this.getSqlSessionTemplate().delete("com.learn.chapter8.dao.UserDAO.deleteUser", id);
    }
}
