package com.example.demo.db.repository;

import com.example.demo.anno.RouteDataSource;
import com.example.demo.common.BaseRepository;
import com.example.demo.constant.DataSources;
import com.example.demo.db.entity.UserTest;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/13 13:54
 */
@Repository
public interface UserRepository extends BaseRepository<UserTest> {
    @Override
    List<UserTest> findAll();
}
