package com.chen.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenchenchen
 * @create 2022-09-01 17:03
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL="http://cloud-providerconsul-payment";

    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }
}
