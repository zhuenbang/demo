package com.example.demo.service;

import com.example.demo.db.entity.UserTest;
import com.example.demo.db.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/13 16:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserRepository userRepository;

    @Test
    public void getAllUser() {
        List<UserTest> all = userRepository.findAll();
        for(UserTest user : all){
            System.out.println(user.toString());
        }
    }
}