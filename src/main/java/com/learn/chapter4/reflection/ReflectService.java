package com.learn.chapter4.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lzy
 * <p>
 * Create Time: 2018/2/7 14:57
 * @version v1.00
 */
public class ReflectService {

    private static final Logger logger = LoggerFactory.getLogger(ReflectService.class);

    public void sayHello(String name) {
        logger.info("hello " + name);
    }

    public static void main(String[] args) {
        try {
            //通过反射创建ReflectService
            Object service = Class.forName(ReflectService.class.getName()).newInstance();
            //获取服务方法
            Method method = service.getClass().getMethod("sayHello", String.class);
            //调用方法
            method.invoke(service, "zhangsan");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            logger.error("[ReflectService reflect]", e);
        } catch (NoSuchMethodException e) {
            logger.error("[ReflectService method]", e);
        } catch (InvocationTargetException e) {
            logger.error("[ReflectService invoke]", e);
        }
    }
}
