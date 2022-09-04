package com.chen.springcloud.controller;

import com.chen.springcloud.entities.CommonResult;
import com.chen.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenchenchen
 * @create 2022-09-03 15:25
 */
@RestController
@Slf4j
public class OpenFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable Long id){
        return paymentFeignService.getPayment(id);
    }
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
