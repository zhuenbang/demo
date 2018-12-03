package com.example.demo.api;

import com.example.demo.result.Result;
import com.example.demo.service.AuthTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhuenbang on 2018/12/3 11:32
 */
@RestController
public class AuthTokenApi {
    @Autowired
    private AuthTokenService authTokenService;

    @GetMapping("/getToken")
    Result getToken(String userId) throws Exception {
        return Result.success(authTokenService.getToken(userId));
    }
}
