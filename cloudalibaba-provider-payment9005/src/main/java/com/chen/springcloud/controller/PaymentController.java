package com.chen.springcloud.controller;

import com.chen.springcloud.entities.CommonResult;
import com.chen.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author chenchenchen
 * @create 2022-09-28 11:18
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap=new HashMap<Long, Payment>();
    static {
        hashMap.put(1L,new Payment(1L,"ddsa5s5as1cca584a1c1s5s5c"));
        hashMap.put(2L,new Payment(2L,"icao651c5ac1s54csa15ca1c5"));
        hashMap.put(3L,new Payment(3L,"215cas15ca15xa1c5s1ca15sa"));
    }

    @GetMapping("/provider/payment/{id}")
    public CommonResult payment(@PathVariable ("id") Long id){
        Payment payment = hashMap.get(id);
        return new CommonResult(200,"成功，serverPort："+serverPort,payment);
    }


}
