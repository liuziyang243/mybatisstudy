package com.learn.chapter8.aop;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by liuziyang
 * Create date: 2018/2/26
 *
 * @author liuziyang
 */
@Getter
@Setter
public class TimeEntity {
    private String className;
    private String methodName;
    private long handlingTime;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[Class]:").append(className).append(",")
                .append("[Method]:").append(methodName).append(",")
                .append("[Handle Time]:").append(handlingTime).append("(ms)");
        return builder.toString();
    }
}
