package com.springcloud.service.impl;

import com.chen.springcloud.entities.CommonResult;
import com.chen.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author chenchenchen
 * @create 2022-09-28 15:27
 */
@Component
public class PaymentFallbackService implements PaymentService {

    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<Payment>(444,"服务降级返回  ----PaymentFallbackService",new Payment(id,"error"));
    }
}
