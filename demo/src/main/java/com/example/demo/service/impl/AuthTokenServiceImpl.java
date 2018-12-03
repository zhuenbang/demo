package com.example.demo.service.impl;

import com.example.demo.redis.RedisService;
import com.example.demo.redis.UserKey;
import com.example.demo.result.Result;
import com.example.demo.service.AuthTokenService;
import com.example.demo.util.AESUtil;
import com.google.common.base.Joiner;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Create by zhuenbang on 2018/12/3 11:34
 */
@Service
public class AuthTokenServiceImpl implements AuthTokenService {
    final Logger logger = Logger.getLogger(AuthTokenServiceImpl.class);
    @Autowired
    private RedisService redisService;

    @Override
    public String getToken(String userId) throws Exception {
        String token = AESUtil.encryptByDefaultKey(Joiner.on("_").join(userId, System.currentTimeMillis()));
        logger.debugv("token= {0}", token);
        redisService.set(UserKey.userAccessKey, userId, token);
        return token;
    }

    @Override
    public String checkToken(String token) throws Exception {
        String userId = AESUtil.decryptByDefaultKey(token).split("_")[0];
        String currentToken = redisService.get(UserKey.userAccessKey, userId, String.class);
        logger.debugv("currentToken={0}", currentToken);
        if (StringUtils.isEmpty(currentToken)) {
            return null;
        }
        if (!token.equals(currentToken)) {
            return null;
        }
        return userId;
    }

    @Override
    public Result login() throws Exception {
        String userId = "123456";
        return Result.success(this.getToken(userId));
    }

    @Override
    public Result testSSO() {
        return Result.success("登录状态正常");
    }
}
