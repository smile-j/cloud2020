package com.dong.springcloud.service;

import com.dong.springcloud.comm.rep.PageResponse;
import com.dong.springcloud.comm.rep.Response;
import com.dong.springcloud.comm.req.PageRequest;
import com.dong.springcloud.entity.UserEntity;
import com.dong.springcloud.vo.req.UserVo;

import java.util.List;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/8
 */
public interface IUserService {
    Response<UserEntity> insertOne(UserEntity user);

    Response<Integer> batchUsers(List<UserEntity> users);

    PageResponse<List<UserEntity>> findUsers(PageRequest<UserVo> reqData);

    Response<Integer> delUser(UserEntity user);
}
