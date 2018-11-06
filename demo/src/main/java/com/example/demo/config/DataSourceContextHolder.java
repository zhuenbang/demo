package com.example.demo.config;

import com.example.demo.constant.DataSources;
import org.jboss.logging.Logger;

/**
 * @author zhuenbang
 * @description
 * @date 2018/8/13 12:57
 */
public class DataSourceContextHolder {
    private static Logger logger  = Logger.getLogger(DataSourceContextHolder.class);
    /**
     * 默认数据源
     */
    public static final String DEFAULT_DATASOURCE = DataSources.MASTER_DB;

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    // 设置数据源名
    public static void setDB(String dbType) {
        logger.debugv("切换到{}数据源", dbType);
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}
