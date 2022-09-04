package com.chen.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenchenchen
 * @create 2022-09-03 18:18
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface OrderPaymentService {
    @GetMapping("/payment/ok/{id}")
    public String getPayment_Ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/fail/{id}")
    public String getPayment_Fail(@PathVariable("id") Integer id);
}
