package com.learn.chapter2.po;

import com.learn.chapter2.main.RoleKind;
import lombok.Data;

import java.util.List;

/**
 * @author lzy
 * <p>
 * Create Time: 2018/2/1 17:21
 * @version v1.00
 */
@Data
public class Role {
    private Long id;
    private String roleName;
    private String note;
    private List<String> rights;
    private RoleKind kind;
}
