package com.example.demo.filter;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Create by zhuenbang on 2018/12/3 11:06
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface Secured {
}
