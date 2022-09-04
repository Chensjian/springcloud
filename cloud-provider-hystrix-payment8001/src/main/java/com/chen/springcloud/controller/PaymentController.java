package com.chen.springcloud.controller;

import com.chen.springcloud.entities.CommonResult;
import com.chen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenchenchen
 * @create 2022-09-03 16:50
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/ok/{id}")
    public String getPayment_Ok(@PathVariable("id") Integer id){
        String res = paymentService.paymentInfo_OK(id);
        log.info("*****res:"+res);
        return res;
    }
    @GetMapping("/payment/fail/{id}")
    public String getPayment_Fail(@PathVariable("id") Integer id){
        String res = paymentService.paymentInfo_Timeout(id);
        log.info("*****res:"+res);
        return res;
    }
    @GetMapping("/payment/circuit/{id}")
    public String circuit(@PathVariable("id") Integer id){
        String res=paymentService.paymentCircuitBreaker(id);
        log.info("******res:"+res);
        return res;
    }

}
