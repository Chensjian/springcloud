package com.chen.springcloud.service.impl;

import com.chen.springcloud.dao.StorageDao;
import com.chen.springcloud.domain.CommonResult;
import com.chen.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenchenchen
 * @create 2022-10-02 10:34
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    public void decrease(Long productId, Integer count) {
        log.info("---->开始对库存做扣减");
        storageDao.decrease(productId,count);
        log.info("---->做扣减结束");
    }
}
