package com.learn.chapter4.jdkproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lzy
 * <p>
 * Create Time: 2018/2/7 15:06
 * @version v1.00
 */
public class HelloServiceProxy implements InvocationHandler {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceProxy.class);

    //真实服务对象
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        // 获取代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("------------------this is JDK proxy----------------");
        Object result = null;
        //反射方法前调用
        logger.info("before");
        //执行方法
        result = method.invoke(target, args);
        //反射后方法调用
        logger.info("after");
        return result;
    }
}
