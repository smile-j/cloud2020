package com.dong.springcloud.service.impl;

import com.dong.springcloud.dao.DeptDao;
import com.dong.springcloud.entity.DeptEntity;
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
public class DeptService {


    @Autowired
    private DeptDao deptDao;

//    @Transactional
//    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public void insert(DeptEntity deptEntity){
        if("11".equals(deptEntity.getDeptNo())){
            log.info("--DeptService-insert--createException-");
            throw new RuntimeException("DeptService createException");
        }
        deptDao.insertOne(deptEntity);
    }
    public DeptEntity findById(Integer id){
        return deptDao.selectById(id);
    }

    public List<DeptEntity> findList(DeptEntity deptEntity){
        return deptDao.selectList(deptEntity);
    }



}
