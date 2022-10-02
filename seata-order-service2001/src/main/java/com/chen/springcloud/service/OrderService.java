package com.chen.springcloud.service;

import com.chen.springcloud.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenchenchen
 * @create 2022-10-01 17:00
 */
public interface OrderService {
    //1 新建订单
    void create(Order order);
    //2 修改订单状态，从零改为1
    void update(Long userId, Integer status);
}
