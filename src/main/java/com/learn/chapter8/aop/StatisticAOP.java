package com.learn.chapter8.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by liuziyang
 * Create date: 2018/2/26
 *
 * @author liuziyang
 */
@Component
@Aspect
public class StatisticAOP {
    private static final Logger logger = LoggerFactory.getLogger(StatisticAOP.class);
    private long startTime = 0;

    /**
     * 对com.mysite.test包下面所有子包所有public方法有效，此方法不能有返回值
     */
    @Pointcut("execution(public * com.learn.chapter8..*.*(..))")
    public void recordTime() {
    }


    @Before("recordTime()")
    public void before(JoinPoint jp) {
        //获取访问时的当前时间
        startTime = System.currentTimeMillis();
    }


    @AfterReturning("recordTime()")
    public void afterReturning(JoinPoint jp) {
        //计算出调用方法返回的用时
        long process = System.currentTimeMillis() - startTime;
        //获取类名
        String className = jp.getThis().toString();
        // 获得方法名
        String methodName = jp.getSignature().getName();
        TimeEntity e = new TimeEntity();
        e.setClassName(className);
        e.setMethodName(methodName);
        e.setHandlingTime(process);
        logger.info(e.toString());
    }
}
