package com.example.demo.service;

import com.example.demo.anno.RouteDataSource;
import com.example.demo.constant.DataSources;
import com.example.demo.db.entity.UserTest;
import com.example.demo.db.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/13 16:18
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    @RouteDataSource(DataSources.MASTER_DB)
    public List<UserTest> getAllUser(){
        return userRepository.findAll();
    }
}
