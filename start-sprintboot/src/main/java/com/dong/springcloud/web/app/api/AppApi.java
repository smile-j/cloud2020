package com.dong.springcloud.web.app.api;

import com.dong.springcloud.comm.rep.Response;
import com.dong.springcloud.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/7/30
 */
@Api(value = "app-app",tags = "app-api")
@RequestMapping("/app")
public interface AppApi {

    @ApiOperation("通过用户id")
    @GetMapping("/getUser/{id}")
    Response<UserEntity> getUserById(@PathVariable("id") String id);


}
