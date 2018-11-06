package com.example.demo.db.repository;

import com.example.demo.db.entity.UserTest;
import org.jboss.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/13 13:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NatureExpertsTypeRepositoryTest {
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
    private UserRepository repository;


    @Test
    public void findAllExpertsType(){
        List<UserTest> all = repository.findAll();
        logger.info(all.toArray());
    }
}