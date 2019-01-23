package com.yr.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * mybits 多数据源
 * @author zxy-un
 * 
 * 2018年7月17日 上午11:49:15
 */
@Configuration // 注册到springboot容器中 -- 扫描xml(配置文件)
@MapperScan(basePackages = {"com.yr.mapper1"}, sqlSessionFactoryRef = "test1SqlSessionFactory") // 只扫描接口 -- 使用多数据源时打开(记得将mybits jar导入)
public class DataSource1Config {
     
    @Bean(name = "test1DataSource") // 与 41 行的qualifier 名字一致
    @Primary 
    @ConfigurationProperties(prefix = "spring.datasource.test1") // 配置文件中使用的 datasource
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }
 
     
    @Bean(name = "test1SqlSessionFactory") // 以注解的方式建立sessionfactory
    @Primary // @Primary的意思是在众多相同的bean中，优先使用用@Primary注解的bean 而@Qualifier这个注解则指定某个bean有没有资格进行注入
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
//        		.getResources("classpath:com/yr/mapper1/*.xml")); // 扫描配置文件
        return bean.getObject();
    }
 
     
    @Bean(name = "test1TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
 
    @Bean(name = "test1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
 
}