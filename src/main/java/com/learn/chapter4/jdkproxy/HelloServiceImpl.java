package com.learn.chapter4.jdkproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lzy
 * <p>
 * Create Time: 2018/2/7 15:05
 * @version v1.00
 */
public class HelloServiceImpl implements HelloService {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public void sayHello(String name) {
        logger.info("hello " + name);
    }
}
