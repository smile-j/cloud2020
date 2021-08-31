package com.dong.springcloud.web.app.controller;

import com.dong.springcloud.comm.rep.Response;
import com.dong.springcloud.entity.UserEntity;
import com.dong.springcloud.service.impl.UserServiceImpl;
import com.dong.springcloud.web.app.api.AppApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/30
 */
@Slf4j
@RestController
public class AppController implements AppApi {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public Response<UserEntity> getUserById(String id) {
        return userService.getUserById(id);
    }
}
