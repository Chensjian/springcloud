package com.chen.springcloud.service.impl;

import com.chen.springcloud.dao.AccountDao;
import com.chen.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author chenchenchen
 * @create 2022-10-02 11:07
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    public void decrease(Long userId, BigDecimal money) {
        log.info("---->账户余额正在做扣减");
//        int a=10/0;
        accountDao.decrease(userId, money);
        log.info("---->账户余额做扣减结束");
    }
}
