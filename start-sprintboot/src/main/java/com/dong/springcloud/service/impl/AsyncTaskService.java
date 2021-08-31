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
    @Async
    public void testAsyn(UserEntity userEntity) {
        log.info("------222222--------------");
        TimeUnit.SECONDS.sleep(5);
        log.info("-----------3333---------");
        userDao.insert(userEntity);
    }
    @Async
    public void testThreadPool() throws InterruptedException {
        log.info("---testThreadPool---start--------------");
        TimeUnit.SECONDS.sleep(5);
        log.info("---testThreadPool---end--------------");
    }


}
