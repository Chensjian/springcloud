package com.chen.springcloud.controller;

import com.chen.springcloud.entities.CommonResult;
import com.chen.springcloud.entities.Payment;
import com.chen.springcloud.service.PaymentService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenchenchen
 * @create 2022-08-29 19:28
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果："+payment);
        if(payment!=null){
            return new CommonResult<Payment>(200,"查询成功,serverPort:"+serverPort,payment);
        }else{
            return new CommonResult<Payment>(100,"没有对应记录",null);
        }

    }

    @PostMapping("/payment/create")
    public CommonResult insertPayment(@RequestBody Payment payment){
        log.info("payment："+payment);
        int row = paymentService.create(payment);
        log.info("****插入结果："+row);
        if(row>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort);
        }else {
            return new CommonResult(100,"插入数据失败",null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String s:services){
            log.info(s);
        }
        List<ServiceInstance> list = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
       for(ServiceInstance s:list){
           log.info(s.getHost()+"\t"+s.getPort()+"\t"+s.getUri());
       }
        return this.discoveryClient;
    }
    @GetMapping("/payment/lb")
    public String getServerPort(){
        return serverPort;
    }
}
