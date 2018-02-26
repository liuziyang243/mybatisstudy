package com.learn.chapter8.po;

import lombok.Data;

/**
 * @author lzy
 * <p>
 * Create Time: 18-2-26 下午2:31
 * @version v1.00
 */
@Data
public class User {
    private long id;
    private String userName;
    private String cnname;
    private short sex;
    private String mobile;
    private String email;
    private String note;
}
