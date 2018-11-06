package com.example.demo.api;

import com.example.demo.db.entity.UserTest;
import com.example.demo.service.UserService;
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
}
