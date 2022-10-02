package com.chen.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenchenchen
 * @create 2022-10-02 10:38
 */
@Configuration
@MapperScan(value = {"com.chen.springcloud.dao"})
public class MybaitConfig {
}
