package com.dong.springcloud.web.controller;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 *
 *
 *
 *
 * @author dongjunpeng
 * @Description
 * @date 2021/7/7
 */
@RestController
@Slf4j
@RequestMapping("/testParam")
public class TestParamController {

    @GetMapping("/test")
    public String test(){
        int a =1/0;
        return "hello world!";
    }

    //car/2/ower/zhangsan
    @GetMapping("/car/{id}/ower/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                         @PathVariable("username") String username,
                         @PathVariable Map<String,Object> kv){

        return ImmutableMap.<String, Object>builder().put("id", id).
                put("userName", username).
                put("kv", kv).build();
    }


}
