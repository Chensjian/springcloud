//package com.chen.springcloud.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
//
//import com.alibaba.nacos.common.packagescan.resource.PathMatchingResourcePatternResolver;
//import com.alibaba.nacos.common.packagescan.resource.PathResource;
//import com.alibaba.nacos.common.packagescan.resource.ResourcePatternResolver;
//import io.seata.rm.datasource.DataSourceProxy;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.transaction.SpringManagedTransaction;
//import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.core.io.Resource;
//
//
//import javax.sql.DataSource;
//import java.io.FileInputStream;
//
///**
// * @author chenchenchen
// * @create 2022-10-01 17:48
// */
//@Configuration
//public class DataSourceProxyConfig {
//    @Value("${mybatis.mapper-locations}")
//    private String mapperLocations;
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource(){
//        return new DruidDataSource();
//    }
//    @Bean
//    public DataSourceProxy dataSourceProxy(DataSource dataSource){
//        return new DataSourceProxy(dataSource);
//    }
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSourceProxy dataSourceProxy) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
//        sqlSessionFactoryBean.setMapperLocations((Resource) new PathMatchingResourcePatternResolver().getResource(mapperLocations));
//        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
//        return sqlSessionFactoryBean.getObject();
//    }
//}
