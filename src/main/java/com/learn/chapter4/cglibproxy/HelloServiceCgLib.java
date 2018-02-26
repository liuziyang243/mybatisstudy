package com.learn.chapter4.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author lzy
 * <p>
 * Create Time: 2018/2/7 15:15
 * @version v1.00
 */
public class HelloServiceCgLib implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(HelloServiceCgLib.class);

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        logger.info("------------------this is CGLib proxy----------------");
        Object result = null;
        //反射方法前调用
        logger.info("before");
        //执行方法
        result = methodProxy.invokeSuper(o, objects);
        //反射后方法调用
        logger.info("after");
        return result;
    }
}
