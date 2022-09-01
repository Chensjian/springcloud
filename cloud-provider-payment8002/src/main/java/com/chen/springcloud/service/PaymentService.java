package com.chen.springcloud.service;

import com.chen.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenchenchen
 * @create 2022-08-29 19:23
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
