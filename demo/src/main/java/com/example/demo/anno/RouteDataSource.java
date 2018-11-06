package com.example.demo.anno;

import com.example.demo.constant.DataSources;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhuenbang
 * @description 自定义数据库注解
 * @date 2018/8/13 11:43
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface RouteDataSource {
    String value() default DataSources.MASTER_DB; //默认为主数据源
}
