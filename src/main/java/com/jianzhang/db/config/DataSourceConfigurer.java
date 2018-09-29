package com.jianzhang.db.config;

import com.jianzhang.db.bean.DataSourceConstant;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
/**
 * @Description: 数据源加载及初始化配置类
 * @author Jian Jang
 * @version 1.0 2018/5/22
 */
@Configuration
public class DataSourceConfigurer {
    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;
    @Bean("master")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.master")
    public DataSource master(){
      return DataSourceBuilder.create().build();
    }

    @Bean("slave1")
    @ConfigurationProperties(prefix="spring.datasource.slave1")
    public DataSource slave1(){
        return DataSourceBuilder.create().build();

    }
    @Bean("slave2")
    @ConfigurationProperties(prefix="spring.datasource.slave2")
    public DataSource slave2(){
        return DataSourceBuilder.create().build();
    }
    /**
     * Dynamic data source. * * @return the data source
     */
    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>(3);
        dataSourceMap.put(DataSourceConstant.DATASOURCE_MASTER, master());
        dataSourceMap.put(DataSourceConstant.DATASOURCE_SLAVE_1, slave1());
        dataSourceMap.put(DataSourceConstant.DATASOURCE_SLAVE_2, slave2());
        // 将 master 数据源作为默认指定的数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(master());
        // 将 master 和 slave1,slave2 数据源作为指定的数据源(放到数据源路由容器中，后期通过对应的key获取数据源)
        dynamicRoutingDataSource.setTargetDataSources(dataSourceMap);
        // 将数据源的 key 放到数据源上下文的 key 集合中，用于切换时判断数据源是否有效
        DynamicDataSourceContextHolder.dataSourceKeysSet.addAll(dataSourceMap.keySet());
        return dynamicRoutingDataSource;
    }


    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource 作为数据源则不能实现切换
        sqlSessionFactoryBean.setDataSource(dynamicDataSource());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        return sqlSessionFactoryBean;
    }

    /**
     * 配置事务管理，如果使用到事务需要注入该 Bean，否则事务不会生效
     * 在需要的地方加上 @Transactional 注解即可
     *
     * @return the platform transaction manager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
