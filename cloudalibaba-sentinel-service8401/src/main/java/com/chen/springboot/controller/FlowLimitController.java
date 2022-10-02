package com.chen.springboot.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/testC")
    public String testC(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testC";
    }

    @GetMapping("/testE")
    @SentinelResource(value = "testE",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "----------testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "--------------deal_testHotKey";
    }
}
