package com.example.demo.service;

import com.example.demo.result.Result;

/**
 * Create by zhuenbang on 2018/12/3 11:33
 */
public interface AuthTokenService {

    /** 
    * @Description: 获取token 
    * @Param:  
    * @returns: java.lang.String 
    * @Author: zhuenbang
    * @Date: 2018/12/3 11:45
    */
    String getToken(String userId) throws Exception;
    
    
    /** 
    * @Description: 校验token 
    * @Param:  
    * @returns: java.lang.String 
    * @Author: zhuenbang
    * @Date: 2018/12/3 11:48
    */
    String checkToken(String token) throws Exception;


    /**
    * @Description: 模拟登录获取token
    * @Param:
    * @returns: com.example.demo.result.Result
    * @Author: zhuenbang
    * @Date: 2018/12/3 12:03
    */
    Result login() throws Exception;

    
    /** 
    * @Description: 模拟单点登录 
    * @Param:  
    * @returns: com.example.demo.result.Result 
    * @Author: zhuenbang
    * @Date: 2018/12/3 12:35
    */
    Result testSSO();
}
