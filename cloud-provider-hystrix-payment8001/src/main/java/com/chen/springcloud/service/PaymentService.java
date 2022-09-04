package com.chen.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

/**
 * @author chenchenchen
 * @create 2022-09-03 16:46
 */
@Component
public class PaymentService {
    /**
     * 正常访问的方法
     *
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_OK,id:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int i=10/0;
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_Fail,id:" + id;
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_FailHandler,id:" + id + "系统繁忙，请稍后再试";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value="true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率高达多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("*******id 不能为负数");
        }
        String uuid = UUID.randomUUID().toString();
        return Thread.currentThread().getName()+"\t调用成功,流水号为"+uuid;
    }
    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能负数，请稍后再试 id:"+id;
    }

}
