package com.dong.springcloud.web.controller;

import com.dong.springcloud.comm.rep.PageResponse;
import com.dong.springcloud.comm.rep.Response;
import com.dong.springcloud.comm.req.PageRequest;
import com.dong.springcloud.entity.UserEntity;
import com.dong.springcloud.service.IUserService;
import com.dong.springcloud.vo.req.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/8
 */
@RestController
@Slf4j
@RequestMapping("/user")
@Api(value = "user接口", tags = "user接口")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("user save")
    @PostMapping("/save")
    public Response<UserEntity> saveUser(@RequestBody UserEntity user){
        return userService.insertOne(user);

    }

    @ApiOperation("post-batchSave")
    @PostMapping("/batchSave")
    public Response<Integer> saveUsers(@RequestBody List<UserEntity> users){
        return userService.batchUsers(users);
    }

    @ApiOperation("post-searchUser")
    @PostMapping("/searchUser")
    public PageResponse<List<UserEntity>> getUsers(@RequestBody PageRequest<UserVo> reqData){
        return userService.findUsers(reqData);
    }

    @ApiOperation("post-delUser")
    @PostMapping("/delUser")
    public Response<Integer> delUser(@RequestBody UserEntity user){
        return userService.delUser(user);
    }


}
