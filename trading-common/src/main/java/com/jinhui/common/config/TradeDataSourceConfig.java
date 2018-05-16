package com.jinhui.common.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 交易平台数据源配置
 *
 * @autor wsc
 * @create 2018-02-08 9:30
 **/
@Configuration
@MapperScan(basePackages = "com.jinhui.*.mapper.trade", sqlSessionTemplateRef = "tradeSqlSessionTemplate")
public class TradeDataSourceConfig {
    @Bean(name = "tradeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.trade")
    @Primary
    public DataSource setDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "tradeTransactionManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager(@Qualifier("tradeDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "tradeSqlSessionFactory")
    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("tradeDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        /**
         * classpath* 表示扫描jar包中的文件,在多模块项目中，才能扫到全部的映射文件
         */
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/trade/*.xml"));
        bean.setConfigLocation(new DefaultResourceLoader().getResource("classpath:mybatis.xml"));
        return bean.getObject();
    }

    @Bean(name = "tradeSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("tradeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    /**
     * 使用事务要指定@Transactional(value = "tradeTransactionManager")
     */
    @Bean
    public PlatformTransactionManager tradeTransactionManager(@Qualifier("tradeDataSource") DataSource tradeDataSource) {
        return new DataSourceTransactionManager(tradeDataSource);
    }
}
