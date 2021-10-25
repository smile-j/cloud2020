package com.dong.springcloud.web.pc.controller;

import com.dong.springcloud.entity.Person;
import com.dong.springcloud.vo.req.UserVo;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dongjunpeng
 * @PathVariable、
 * @RequestHeader、
 * @ModelAttribute、
 * @RequestParam、
 * @MatrixVariable、
 * @RequestBody
 * @Description
 * @date 2021/7/7
 */
@RestController
@Slf4j
@RequestMapping("/testParam")
@Api(value = "TestParamController接口", tags = "TestParamController接口")
public class TestParamController {

    @Autowired
    private Person person;

    @GetMapping("getPersonInfo")
    public Object getPersonInfo() {
        return person;
    }

    @ApiOperation("test--")
    @GetMapping("/test")
    public String test() {
        int a = 1 / 0;
        return "hello world!";
    }

    @ApiOperation("test--pathParam")
    //car/2/ower/zhangsan
    @GetMapping("/car/{id}/ower/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String, Object> kv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header) {

        return ImmutableMap.<String, Object>builder().put("id", id).
                put("userName", username).
                put("User-Agent", userAgent).
                put("header", header).
                put("kv", kv).build();
    }

    /**
     * testGetParam?name2=lili&age=22&add=北京
     *
     * @param name
     * @param age
     * @return
     */
    @GetMapping("testGetParam")
    public Map<String, Object> testGet(@RequestParam("name2") String name, @RequestParam("age") Integer age,
                                       @RequestParam Map<String, Object> map,
                                       @CookieValue("CASTGC") String token,
                                       @CookieValue("CASTGC") Cookie cookie) {
        System.out.println(cookie.getName() + "-----" + cookie.getValue());
        return ImmutableMap.<String, Object>builder()
                .put("name2", name)
                .put("age", age)
                .put("map", map)
                .put("CASTGC", token)
                .build();
    }

    /**
     * post json
     * {
     * "id":11,
     * "userName":"aa"
     * }
     *
     * @param userVo
     * @return
     */
    @PostMapping("postReqBody")
    public Object testReqBody(@RequestBody UserVo userVo) {
        return userVo;
    }

    // form表单
    @PostMapping("testForm")
    public Object testForm(UserVo userVo) {
        return userVo;
    }

    //1、语法:/cars/sell;low=34;brand=byd,audi,yd
    // SpringBoot默认是禁用了矩阵变量的功能
    // 手动开启: UrlPathHelper
    @GetMapping("/cars/sell/{path}")
    public Map carssell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path) {

        Map<String, Object> map = new HashMap<>();
        map.put("1ow", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }





}