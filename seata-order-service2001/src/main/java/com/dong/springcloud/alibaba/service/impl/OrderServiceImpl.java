package com.dong.springcloud.alibaba.service.impl;

import com.dong.springcloud.alibaba.dao.OrderDao;
import com.dong.springcloud.alibaba.domain.Order;
import com.dong.springcloud.alibaba.service.AccountService;
import com.dong.springcloud.alibaba.service.Orderservice;
import com.dong.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements Orderservice {

    @Resource
    private OrderDao orderDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;


    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-------开始新建订单------");
        orderDao.create(order);

        log.info("----------订单微服务开始调用库存，做减库存------");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----------订单微服务开始调用库存，做减库存end------");

        log.info("----------订单微服务开始调用库存，扣钱------");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----------订单微服务开始调用库存，扣钱end------");

        //修改订单状态 从0--》1  完成订单
        log.info("----------修改订单状态 start------");
        int num  = orderDao.update(order.getUserId(),0);
        log.info(num+ "----------修改订单状态 end------");

        log.info("-------订单---end---");

    }
}
