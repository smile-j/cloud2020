package com.dong.springcloud.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.dong.springcloud.comm.rep.PageResponse;
import com.dong.springcloud.comm.rep.Response;
import com.dong.springcloud.comm.req.PageRequest;
import com.dong.springcloud.entity.UserEntity;
import com.dong.springcloud.dao.UserDao;
import com.dong.springcloud.service.BaseApiService;
import com.dong.springcloud.service.IUserService;
import com.dong.springcloud.vo.req.UserVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/8
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseApiService implements IUserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private AsyncTaskService taskService;

    @Override
    @Transactional
    public Response<UserEntity> insertOne(UserEntity user) {
//        userDao.insert(user);
        taskService.testAsyn(user);
        applicationEventPublisher.publishEvent(JSON.toJSONString(user));
        int a = 10/0;

        return ok(user);
    }

    @Override
    public Response<Integer> batchUsers(List<UserEntity> users) {
         userDao.batchUsers(users);
         return ok(users.size());
    }

    @Override
    public PageResponse<List<UserEntity>> findUsers(PageRequest<UserVo> reqData) {
        Page<UserEntity> page = PageHelper.startPage(reqData.getPageInfo().getPageNum(), reqData.getPageInfo().getPageSize());
        userDao.findUsers(reqData.getData());
        page.close();
        return PageResponse.page(page.getResult(),page.getTotal());
//        return PageResponse.page(page.getResult(),page.getTotal());


    }

    @Override
    public Response<Integer> delUser(UserEntity user) {
        return userDao.delUser(user);
    }

    public Response<UserEntity> getUserById(String id) {
        return ok(UserEntity.builder().userName(id).build());
    }
}
