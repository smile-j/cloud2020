package com.dong.springcloud.dao;

import com.dong.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int savePayment(Payment payment);

    public Payment findById(@Param("id") Long id);

}
