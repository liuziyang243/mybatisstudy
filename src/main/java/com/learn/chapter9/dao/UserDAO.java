package com.learn.chapter9.dao;

import com.learn.chapter8.po.User;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author lzy
 * @create 2018-02-27 下午2:43
 */
public interface UserDAO {
    List<User> findUsersByName(String userName, RowBounds rowBounds);
}
