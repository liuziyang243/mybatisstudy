package com.learn.chapter4.jdkproxy;

import com.learn.chapter4.cglibproxy.HelloServiceCgLib;

/**
 * @author lzy
 * <p>
 * Create Time: 2018/2/7 15:12
 * @version v1.00
 */
public class App {
    public static void main(String[] args) {
        HelloServiceProxy proxy = new HelloServiceProxy();
        HelloService service = (HelloService) proxy.bind(new HelloServiceImpl());
        service.sayHello("zhangsan");

        HelloServiceCgLib proxy2 = new HelloServiceCgLib();
        HelloService service2 = (HelloService) proxy2.getInstance(new HelloServiceImpl());
        service2.sayHello("lisi");
    }
}
