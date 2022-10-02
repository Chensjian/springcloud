package com.chen.springcloud.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author chenchenchen
 * @create 2022-10-02 11:06
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
