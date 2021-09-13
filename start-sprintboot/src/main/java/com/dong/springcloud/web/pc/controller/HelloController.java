package com.dong.springcloud.web.pc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/9/7
 */
@RestController
public class HelloController {

    @GetMapping("/1.png")
    public String test1(){
        return "123";
    }

}
