
package com.jianzhang.db.config;

import com.jianzhang.db.bean.DataSourceConstant;

import java.util.HashSet;
import java.util.Set;
/**
 * @Description: 数据源上下文类
 * @author Jian Jang
 * @version 1.0 2018/5/22
 */
public class DynamicDataSourceContextHolder {
    /***
     * 存放合法或者可用的数据源列表，用于切换数据源时合法性验证
     */
    public  final static Set<Object> dataSourceKeysSet = new HashSet<>();
    /***
     * 线程本地变量：用于关联线程与对应的执行方法对应的数据源key:保存线程对应的数据源
     * 默认情况情况下为主库
     */
    private final static  ThreadLocal<String> dataSourceContext =new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return DataSourceConstant.DATASOURCE_MASTER;
        }
    };

    /***
     * 设置线程本地变量：数据源key
     * @param key
     */
    public static void setDataSourceKey(String key){
       dataSourceContext.set(key);
    }

    /***
     * 获取线程本地变量key
     * @return
     */
    public static String getDataSourceKey(){
        return dataSourceContext.get();
    }
    /***
     * 清除线程本地变量key
     * @return
     */
    public static void clearDataSourceKey() {
        dataSourceContext.remove();
    }

    /***
     * 数据源切换时有效性校验
     * @param key
     * @return
     */
    public static  boolean containsDataSourceKey(String key){
        return  dataSourceKeysSet.contains(key);
    }
}


