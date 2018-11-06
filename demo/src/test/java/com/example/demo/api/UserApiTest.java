package com.example.demo.api;

import com.example.demo.db.entity.UserTest;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/13 17:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApiTest {
    @Autowired
    private UserService userService;

    @Test
    public void findAll() {
        List<UserTest> allUser = userService.getAllUser();
        for (UserTest user : allUser) {
            System.out.println(user.toString());
        }
    }
}