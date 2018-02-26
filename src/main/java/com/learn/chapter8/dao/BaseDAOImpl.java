package com.learn.chapter8.dao;

import lombok.Getter;
import lombok.Setter;
import org.mybatis.spring.SqlSessionTemplate;

/**
 * @author lzy
 * <p>
 * Create Time: 18-2-26 下午2:33
 * @version v1.00
 */
@Getter
@Setter
public class BaseDAOImpl {
    private SqlSessionTemplate sqlSessionTemplate = null;
}
