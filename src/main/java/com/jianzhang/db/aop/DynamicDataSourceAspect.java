package com.jianzhang.db.aop;

import com.jianzhang.db.annotation.TargetDataSource;
import com.jianzhang.db.config.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: 数据源动态切面
 * @author Jian Jang
 * @version 1.0 2018/5/22
 */
@Slf4j
@Aspect
@Order(-1)//在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {
    @Before("@annotation(targetDataSource))")
    public void switchDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        if (!DynamicDataSourceContextHolder.containsDataSourceKey(targetDataSource.value())) {
            log.info("DataSource [{}] doesn't exist, use default DataSource [{}] " + targetDataSource.value());
        } else {
            // 切换数据源:将当前线程与对应线程执行的方法的注解数据源绑定，在数据路由的时候使用对应的数据源
            DynamicDataSourceContextHolder.setDataSourceKey(targetDataSource.value());
            log.info("Before Switch DataSource to [{}] in Method [{}] ",new Object[]{
                    DynamicDataSourceContextHolder.getDataSourceKey(),point.getSignature()});
        }
    }

    /***
     * 执行完毕后清除线程本地变量：数据源绑定关系
     * @param point
     * @param targetDataSource
     */
    @After("@annotation(targetDataSource))")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        // 将数据源置为默认数据源
        String  dataSourceKey = DynamicDataSourceContextHolder.getDataSourceKey();
        log.info("After starting to clean DataSource [{}] in Method [{}]",new Object[]{
                dataSourceKey,point.getSignature()});
        DynamicDataSourceContextHolder.clearDataSourceKey();

        log.info("After end to clean DataSource [{}] in Method [{}]",new Object[]{
                dataSourceKey,point.getSignature()});
    }
}


