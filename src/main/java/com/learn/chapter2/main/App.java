package com.learn.chapter2.main;

import com.learn.chapter2.mapper.RoleMapper;
import com.learn.chapter2.po.Role;
import com.learn.chapter2.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lzy
 * <p>
 * Create Time: 2018/2/1 17:17
 * @version v1.00
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
            role.setNote("testNote");
            role.setRoleName("testName");
            List<String> temp = new ArrayList<>();
            temp.add("add");
            temp.add("modify");
            temp.add("del");
            temp.add("select");
            role.setRights(temp);
            role.setKind(RoleKind.ADMIN);
            roleMapper.insertRole(role);
            long id = role.getId();
            logger.info("[role id] "+role.getId().toString());
            logger.info("[role note] "+role.getNote());
            roleMapper.updateRole(id, "revision", "revision note");
            Role role1 = roleMapper.getRole(id);
            logger.info(role1.getRoleName());
            logger.info(roleMapper.selectNote("note", id));
//            Role role1 = roleMapper.getRole(44L);
//            logger.info(role1.getRights().toString());
//            logger.info(role1.getKind().toString());
            sqlSession.commit();
        } catch (Exception e) {
            logger.error("[app]", e);
            if (null != sqlSession) {
                sqlSession.rollback();
            }
        } finally {
            if (null != sqlSession) {
                sqlSession.close();
            }
        }
    }
}
