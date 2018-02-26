package com.learn.chapter9.app;

import com.learn.chapter9.service.FileService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuziyang
 * @create 2018-02-26 21:56
 */
public class App {
    public static void main(String[] args) {
        String path = "J:\\test.txt";
        try {
            FileService.insert(path);
            FileService.getFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
