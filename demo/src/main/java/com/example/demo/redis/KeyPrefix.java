package com.example.demo.redis;

/**
 * Create by zhuenbang on 2018/12/3 10:42
 */
public interface KeyPrefix {
    public int expireSeconds();

    public String getPrefix();
}
