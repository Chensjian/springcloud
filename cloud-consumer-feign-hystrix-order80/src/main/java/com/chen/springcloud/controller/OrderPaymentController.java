package com.chen.springcloud.controller;

import com.chen.springcloud.entities.CommonResult;
import com.chen.springcloud.service.OrderPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author chenchenchen
 * @create 2022-09-03 18:20
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallBackMethod")
public class OrderPaymentController {

    @Autowired
    private OrderPaymentService orderPaymentService;
    //服务降级
    @GetMapping("/consumer/payment/ok/{id}")
    public String getPayment_Ok(@PathVariable("id") Integer id){
        String res = orderPaymentService.getPayment_Ok(id);
        log.info("*****res:"+res);
        return res;
    }

    @GetMapping("/consumer/payment/fail/{id}")
//    @HystrixCommand(fallbackMethod = "getPayment_FailHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String getPayment_Fail(@PathVariable("id") Integer id){
        String res = orderPaymentService.getPayment_Fail(id);
        log.info("*****res:"+res);
        return res;
    }

    public String getPayment_FailHandler(@PathVariable("id") Integer id){
        return "系统超时";
    }

    //下面是全局fallback方法
    public String payment_Global_FallBackMethod(){
        return "Global异常处理信息，请稍后再试";
    }



}
