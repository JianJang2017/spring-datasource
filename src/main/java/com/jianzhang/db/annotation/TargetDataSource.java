package com.jianzhang.db.annotation;

import java.lang.annotation.*;


/**
 * @Description: 数据源切换自定义注解
 * @author Jian Jang
 * @version 1.0 2018/5/22
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
