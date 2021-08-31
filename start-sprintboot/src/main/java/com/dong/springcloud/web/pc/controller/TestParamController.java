package com.dong.springcloud.web.pc.controller;

import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "TestParamController接口", tags = "TestParamController接口")
public class TestParamController {

    @ApiOperation("test--")
    @GetMapping("/test")
    public String test(){
        int a =1/0;
        return "hello world!";
    }

    @ApiOperation("test--pathParam")
    //car/2/ower/zhangsan
    @GetMapping("/car/{id}/ower/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                         @PathVariable("username") String username,
                         @PathVariable Map<String,Object> kv){

        return ImmutableMap.<String, Object>builder().put("id", id).
                put("userName", username).
                put("kv", kv).build();
    }

    @GetMapping("testGetParam")
    public String testGet(@RequestParam("name2") String name,@RequestParam Integer age){
        return "name:"+name+"--age:"+age;
    }


}
