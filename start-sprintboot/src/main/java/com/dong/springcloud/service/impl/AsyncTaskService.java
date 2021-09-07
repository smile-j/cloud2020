package com.dong.springcloud.service.impl;

import com.dong.springcloud.dao.UserDao;
import com.dong.springcloud.entity.UserEntity;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/28
 */
@Service
@Slf4j
public class AsyncTaskService {


    @Autowired
    private UserDao userDao;

    @SneakyThrows
    @Async("lazyTraceExecutor")
    public void testAsyn(UserEntity userEntity) {
        log.info("------222222--------------，{},{}",Thread.currentThread().getId(),Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
        log.info("-----------3333---------");
        userDao.insert(userEntity);
    }
    @Async
    public void testThreadPool() throws InterruptedException {
        log.info("---testThreadPool---start--------------，{},{}",Thread.currentThread().getId(),Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
        log.info("---testThreadPool---end--------------");
    }

    @Async("multiGuaranteeExecutor")
    public void one() throws Exception {
        log.info("---one--{},{}",Thread.currentThread().getId(),Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        log.info("one success");
    }

    @Async("multiGuaranteeExecutor")
    public void two() throws Exception {
        log.info("--two--{},{}",Thread.currentThread().getId(),Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        log.info("two success");
    }

    @Async("simpleExecutor")
    public void three(String str) throws Exception {
        log.info("--three--param--,{}",str);
        log.info("--three--{},{}",Thread.currentThread().getId(),Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        log.info("three success");
    }


}
