package com.dong.springcloud.service.impl;

import com.dong.springcloud.dao.UserDao;
import com.dong.springcloud.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/10/29
 */
@Slf4j
@Service
public class TransactionalService2 {

    @Autowired
    private UserDao userDao;

    public void insert(UserEntity userEntity){
        userDao.insert(userEntity);
    }

}
