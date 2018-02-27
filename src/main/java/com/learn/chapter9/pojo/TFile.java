package com.learn.chapter9.pojo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuziyang
 * @create 2018-02-26 21:28
 */
@Data
public class TFile {
    private Long id;
    //用来保存BLOB字段
    private byte[] file;
}