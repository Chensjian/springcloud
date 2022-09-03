package com.chen.springcloud.controller;

import com.chen.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenchenchen
 * @create 2022-09-01 14:46
 */
@RestController
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;


    private static final String PAYMENT_URL="http://cloud-provider-payment";

    @GetMapping("/payment/zk")
    public String zkPayment(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }

}
