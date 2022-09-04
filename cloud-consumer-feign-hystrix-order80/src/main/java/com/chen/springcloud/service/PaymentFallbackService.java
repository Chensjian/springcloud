package com.chen.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author chenchenchen
 * @create 2022-09-04 9:23
 */
@Component
public class PaymentFallbackService implements OrderPaymentService {
    public String getPayment_Ok(Integer id) {
        return "----------PaymentFallbackService fall back-paymentInfo_Ok";
    }

    public String getPayment_Fail(Integer id) {
        return "----------PaymentFallbackService fall back-paymentInfo_Timeout";
    }
}
