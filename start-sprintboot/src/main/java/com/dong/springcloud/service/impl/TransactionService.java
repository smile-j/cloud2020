package com.dong.springcloud.service.impl;

import com.dong.springcloud.entity.DeptEntity;
import com.dong.springcloud.entity.LogEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/10/29
 */
@Slf4j
@Service
public class TransactionService {

    @Autowired
    private DeptService deptService;
    @Autowired
    private TransactionalService transactionalService;
    @Autowired
    private TransactionalService2 transactionalService2;

//    @Transactional(isolation = Isolation.DEFAULT,propagation= Propagation.NOT_SUPPORTED,rollbackFor = Exception.class)

    /**
     * 1.
     * propagation_required
     * 如果当前没有事务，就新建一个事务，如果已存在一个事务中，加入到这个事务中，这是最常见的选择。
     *
     */
    @Transactional(propagation=Propagation.REQUIRED)

    /**
     * 2.
     * propagation_supports
     * 支持当前事务，如果没有当前事务，就以非事务方法执行
     */
//    @Transactional(propagation=Propagation.SUPPORTS)
    /**
     * 3.
     * 使用当前事务，如果没有当前事务，就抛出异常。
     */
//    @Transactional(propagation=Propagation.MANDATORY)//mandatory
    /**
     * 4.
     * 新建事务，如果当前存在事务，把当前事务挂起。
     */
//    @Transactional(propagation=Propagation.REQUIRES_NEW)//requires_new
    /**
     * 5.
     * 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     */
//    @Transactional(propagation=Propagation.NOT_SUPPORTED)
    /**
     * 6.
     * 以非事务方式执行操作，如果当前事务存在则抛出异常。
     */
//    @Transactional(propagation=Propagation.NEVER)
    /**
     * 7.
     * 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED 类似的操作
     */
//    @Transactional(propagation=Propagation.NESTED)
    public void testInsert(){
        deptService.insert(DeptEntity.builder().deptNo("12").deptName("部门11").remarks("备注11").build());
       try{
           transactionalService.insert(LogEntity.builder().content("ggg-bb").createTime(new Date()).type(3).build());
       }catch (Exception e){
           e.printStackTrace();
       }
    }

}
