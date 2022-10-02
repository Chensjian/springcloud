package com.chen.springcloud.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenchenchen
 * @create 2022-10-02 11:05
 */
@Configuration
@MapperScan("com.chen.springcloud.dao")
public class MybatiConfig {
}
