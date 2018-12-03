package com.example.demo.api;

import com.example.demo.db.entity.UserTest;
import com.example.demo.filter.Secured;
import com.example.demo.result.Result;
import com.example.demo.service.AuthTokenService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/13 16:21
 */
@RestController
@RequestMapping("/user")
public class UserApi {
    @Resource
    private UserService userService;
    @Autowired
    private AuthTokenService authTokenService;
    /** 
    * @Description: 测试读写分离
    * @Param: [] 
    * @returns: java.util.List<com.example.demo.db.entity.UserTest> 
    * @Author: zhuenbang
    * @Date: 2018/8/13 16:56
    */
    @GetMapping("/findAll")
    public List<UserTest> findAll(){
        return userService.getAllUser();
    }

    
    /** 
    * @Description: 模拟登录 
    * @Param:  
    * @returns: com.example.demo.result.Result 
    * @Author: zhuenbang
    * @Date: 2018/12/3 12:05
    */
    @GetMapping("/login")
    public Result login() throws Exception {
        return authTokenService.login();
    }
    
    
    /** 
    * @Description: 模拟单点登录 
    * @Param:  
    * @returns: com.example.demo.result.Result 
    * @Author: zhuenbang
    * @Date: 2018/12/3 12:35
    */
    @Secured
    @GetMapping("/testSSO")
    public Result testSSO() {
        return authTokenService.testSSO();
    }
}
