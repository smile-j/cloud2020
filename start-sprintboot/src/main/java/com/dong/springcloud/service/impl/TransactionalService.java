package com.dong.springcloud.service.impl;

import com.dong.springcloud.dao.LogDao;
import com.dong.springcloud.entity.LogEntity;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/10/29
 */
@Slf4j
@Service
public class TransactionalService {

    @Autowired
    private LogDao logDao;

//    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void insert(LogEntity logEntity){
        if(3==logEntity.getType()){
            log.info("--TransactionalService-insert--createException-");
            throw new RuntimeException("TransactionalService createException");
        }
        logDao.insertOne(logEntity);
    }

    public LogEntity queryById(Integer id){
        return logDao.selectById(id);
    }

    public List<LogEntity> queryList(LogEntity logEntity){
        return logDao.selectList(logEntity);
    }

}
