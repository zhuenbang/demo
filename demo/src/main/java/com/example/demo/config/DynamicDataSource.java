package com.example.demo.config;

import org.jboss.logging.Logger;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/13 13:03
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static Logger logger = Logger.getLogger(DynamicDataSource.class);
    @Override
    protected Object determineCurrentLookupKey() {
        logger.debugv("数据源为{}", DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }
}
