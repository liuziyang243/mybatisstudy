package com.learn.chapter2.mapper;

import com.learn.chapter2.po.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzy
 * <p>
 * Create Time: 2018/2/2 11:40
 * @version v1.00
 */
public interface RoleMapper {
    Role getRole(long id);

    int insertRole(Role role);

    int delRole(long id);

    List<Role> getRoleList(@Param("roleName") String roleName, @Param("note") String note);
}
