package com.chen.springcloud.service.impl;

import com.chen.springcloud.dao.PaymentDao;
import com.chen.springcloud.entities.Payment;
import com.chen.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenchenchen
 * @create 2022-08-29 19:25
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
