package com.jianzhang.db.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description: 数据源动态路由
 * @author Jian Jang
 * @version 1.0 2018/5/22
 */
@Slf4j
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        //获取当前线程使用的数据源对应的key
        String key= DynamicDataSourceContextHolder.getDataSourceKey();
        log.info("Current thread uses the {} dataSource",key);
        return key;
    }
}
