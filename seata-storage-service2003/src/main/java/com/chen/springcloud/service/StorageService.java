package com.chen.springcloud.service;

import com.chen.springcloud.domain.CommonResult;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenchenchen
 * @create 2022-10-02 10:30
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
