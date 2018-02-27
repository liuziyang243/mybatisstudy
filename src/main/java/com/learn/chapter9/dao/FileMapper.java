package com.learn.chapter9.dao;

import com.learn.chapter9.pojo.TFile;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuziyang
 * @create 2018-02-26 21:31
 */
public interface FileMapper {
    int insertFile(TFile file);

    TFile getFile(long id);
}
