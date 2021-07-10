package com.potato.core.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: XiongDa
 * @Date: 2021/06/24 19:24
 */
@Configuration
@MapperScan(basePackages = "com.hr.stitchpro.mapper.charizard", sqlSessionFactoryRef = "charizardSqlSessionFactory")
public class CharizardSourceConfig {

    @Bean(name = "charizardDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.charizard")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "charizardSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("charizardDatasource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean.getObject();
    }

}
