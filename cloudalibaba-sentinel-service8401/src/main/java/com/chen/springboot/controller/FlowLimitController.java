package com.chen.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenchenchen
 * @create 2022-09-24 20:25
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "----testB";
    }
}
