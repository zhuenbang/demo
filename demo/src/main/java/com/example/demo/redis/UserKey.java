package com.example.demo.redis;

/**
 * Create by zhuenbang on 2018/12/3 10:52
 */
public class UserKey extends BasePrefix {
    public UserKey(String prefix) {
        super(prefix);
    }

    public UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static UserKey userAccessKey = new UserKey("access");
}
