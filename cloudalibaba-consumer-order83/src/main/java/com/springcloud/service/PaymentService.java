package com.springcloud.service;

import com.chen.springcloud.entities.CommonResult;
import com.chen.springcloud.entities.Payment;
import com.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenchenchen
 * @create 2022-09-28 15:24
 */
@Component
@FeignClient(value = "cloudalibaba-provider-payment",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping("/provider/payment/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
