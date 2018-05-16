package com.jinhui.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 清算数据库配置
 *
 * @autor wsc
 * @create 2018-02-08 9:36
 **/
@Configuration
@MapperScan(basePackages = "com.jinhui.*.mapper.scheduler", sqlSessionTemplateRef = "schedulerSqlSessionTemplate")
public class SchedulerDataSourceConfig {
    @Bean(name = "schedulerDataSource" )
    @ConfigurationProperties(prefix = "spring.datasource.scheduler")
    public DataSource setDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "schedulerTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("schedulerDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "schedulerSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("schedulerDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        /**
         * classpath* 表示扫描jar包中的文件,在多模块项目中，才能扫到全部的映射文件
         */
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/scheduler/*.xml"));
        bean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis.xml"));
        return bean.getObject();
    }

    @Bean(name = "schedulerSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("schedulerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean
    public PlatformTransactionManager schedulerTransactionManager(@Qualifier("schedulerDataSource") DataSource schedulerDataSource) {
        return new DataSourceTransactionManager(schedulerDataSource);
    }


}
