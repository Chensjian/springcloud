package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.chen.springcloud.entities.CommonResult;
import com.chen.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import com.springcloud.service.impl.PaymentFallbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author chenchenchen
 * @create 2022-09-28 12:12
 */
@RestController
public class ConsumerController {

    private final static String SERVER_URL="http://cloudalibaba-provider-payment";

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;
//
//    @GetMapping("/consumer/{id}")
//    //@SentinelResource(value = "fallback")//没有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",
//            blockHandler = "blockHandler",
//            exceptionsToIgnore = {IllegalArgumentException.class})//fallback只负责业务异常
//    //exceptionsToIgnore = {IllegalArgumentException.class})忽略某个异常
//    public CommonResult consumer(@PathVariable("id") Long id){
//
//        CommonResult result = restTemplate.getForObject(SERVER_URL + "/provider/payment/" + id, CommonResult.class);
//        if(id==4){
//            throw new IllegalArgumentException("非法参数异常");
//        }else if(result.getData()==null){
//            throw new NullPointerException("该id没有对应的记录，空指针异常");
//        }
//        return result;
//    }
//    //本例是fallback
//    public CommonResult handlerFallback(@PathVariable("id") Long id,Throwable e){
//        Payment payment = new Payment(id, null);
//        return new CommonResult(444,"兜底异常内容"+e.getMessage(),payment);
//    }
//    //本例是blockhandler
//    public CommonResult blockHandler(@PathVariable("id") Long id,Throwable e){
//        Payment payment = new Payment(id, null);
//        return new CommonResult(444,"blockHandler异常内容"+e.getMessage(),payment);
//    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }
}
