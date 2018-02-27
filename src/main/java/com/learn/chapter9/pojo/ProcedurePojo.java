package com.learn.chapter9.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author lzy
 * <p>
 * Create Time: 18-2-27 上午11:08
 * @version v1.00
 */
@Data
public class ProcedurePojo {
    private String userName = null;
    private int result = 0;
    private Date execDate;
}
