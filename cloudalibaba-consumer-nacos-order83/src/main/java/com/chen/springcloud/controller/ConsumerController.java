package com.chen.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenchenchen
 * @create 2022-09-22 16:07
 */
@RestController
public class ConsumerController {

    @Value("${service-url.nacos-url-service}")
    private String URl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/nacos/consumer/{id}")
    public String order(@PathVariable("id") Integer id){
       return restTemplate.getForObject(URl+"/payment/nacos/"+id,String.class);
    }

}
