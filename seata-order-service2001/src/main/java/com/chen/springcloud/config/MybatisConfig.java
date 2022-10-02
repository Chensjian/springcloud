package com.chen.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenchenchen
 * @create 2022-10-01 17:48
 */
@Configuration
@MapperScan("com.chen.springcloud.dao")
public class MybatisConfig {
}
