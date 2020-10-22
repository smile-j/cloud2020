package com.dong.springcloud.alibaba.dao;


import com.dong.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface OrderDao {

    void create(Order order);
    int update(@Param("userId") Long useId,@Param("status") Integer status);
}
