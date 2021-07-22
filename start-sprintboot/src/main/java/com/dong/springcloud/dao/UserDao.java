package com.dong.springcloud.dao;

import com.dong.springcloud.comm.rep.Response;
import com.dong.springcloud.entity.UserEntity;
import com.dong.springcloud.vo.req.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/8
 */
@Mapper
public interface UserDao {
    void insert(UserEntity user);

    void batchUsers(List<UserEntity> users);

    Response<Integer> delUser(UserEntity user);

    List<UserEntity> findUsers(UserVo data);
}
