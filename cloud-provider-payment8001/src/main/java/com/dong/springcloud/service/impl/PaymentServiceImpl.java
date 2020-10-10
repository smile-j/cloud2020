package com.dong.springcloud.service.impl;

import com.dong.springcloud.dao.PaymentDao;
import com.dong.springcloud.entities.Payment;
import com.dong.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int savePayment(Payment payment) {
        return paymentDao.savePayment(payment);
    }

    @Override
    public Payment findById(Long id) {
        return paymentDao.findById(id);
    }
}
