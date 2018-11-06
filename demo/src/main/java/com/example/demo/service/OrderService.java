package com.example.demo.service;

import com.example.demo.util.RedisLock;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/11 11:03
 */
@Service
public class OrderService {
    final Logger logger = Logger.getLogger(getClass());
    public static final int TIMEOUT = 5 * 1000;//设置超时时间为5秒
    @Resource
    private RedisLock redisLock;


    /**
     * @Description: 模仿使用redis分布式锁
     * @Param: []
     * @returns: void
     * @Author: zhuenbang
     * @Date: 2018/8/11 11:06
     */
    private void deductionStock() {
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        String productId = "123456";
        if (!redisLock.lock(productId, String.valueOf(time))) {
            logger.errorv("【商品id】:{},扣减库存失败，稍后从试");
        }
        //业务代码

        //解锁
        redisLock.unlock(productId, String.valueOf(time));
    }


}
