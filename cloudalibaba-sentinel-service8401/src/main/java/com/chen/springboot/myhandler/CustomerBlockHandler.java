package com.chen.springboot.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chen.springcloud.entities.CommonResult;

/**
 * @author chenchenchen
 * @create 2022-09-27 22:28
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException e){
        return new CommonResult(444,"按客户自定义，global handlerException");
    }
    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(444,"按客户自定义，global handlerException2");
    }
}
