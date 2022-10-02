package com.chen.springcloud.service.impl;

import com.chen.springcloud.dao.OrderDao;
import com.chen.springcloud.domain.Order;
import com.chen.springcloud.service.AccountService;
import com.chen.springcloud.service.OrderService;
import com.chen.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenchenchen
 * @create 2022-10-01 17:02
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;

    @GlobalTransactional(name = "fuzhou-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("---->开始新建订单");
        orderDao.create(order);
        log.info("---->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("---->订单微服务开始调用库存，做扣减结束");
        log.info("---->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("---->订单微服务开始调用账户，做扣减Money结束");

        //修改订单的状态，从零到1，1代表已经完成
        log.info("---->修改订单状态开始");
        orderDao.update(order.getUserId(),order.getStatus());
        log.info("---->修改订单状态结束");

        log.info("---->下订单结束了，哈哈");
    }

    public void update(Long userId, Integer status) {
        orderDao.update(userId,status);
    }
}
