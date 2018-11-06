package com.example.demo.config;
import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import com.example.demo.constant.DataSources;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author zhuenbang
 * @description 定义数据库实体类并配置为多数据源的形式
 * @date 2018/8/13 11:28
 */
@Configuration
public class DatasourceConfig {
    private final static String MASTER_DATASOURCE_KEY = DataSources.MASTER_DB;
    private final static String SLAVE_DATASOURCE_KEY = DataSources.SLAVE_DB;

    //destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
    @Value("${spring.datasource-slave.type}")
    private Class<? extends DataSource> dataSourceType;

    @Primary
    @Qualifier(MASTER_DATASOURCE_KEY)
    @Bean(destroyMethod =  "close", name = DataSources.MASTER_DB, initMethod="init")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        System.out.println("-------------------- primaryDataSource初始化 ---------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(destroyMethod =  "close", name = DataSources.SLAVE_DB,initMethod="init")
    @Qualifier(SLAVE_DATASOURCE_KEY)
    @ConfigurationProperties(prefix = "spring.datasource-slave")
    public DataSource dataSourceSlave() {
        System.out.println("-------------------- slaveDataSource初始化---------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
}
