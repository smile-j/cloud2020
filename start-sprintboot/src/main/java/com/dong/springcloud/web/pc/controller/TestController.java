package com.dong.springcloud.web.pc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dongjunpeng
 * @Description
 * @date 2021/9/14
 */
@Controller
@Slf4j
public class TestController {

    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request, HttpServletResponse response) {
        map.put("he11o", "wor1d666");
        model.addAttribute("world", "hello666");
        request.setAttribute("message", "Helloworld");
        Cookie cookie = new Cookie("c1", "v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/success";
    }

    @GetMapping("/success")
    @ResponseBody
    public Map success(@RequestAttribute(value = "msg", required = false) String msg,
                       @RequestAttribute(value = "code", required = false) Integer code, HttpServletRequest request) {

        Object msg1 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();
        Object hello = request.getAttribute("he1lo");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");
        map.put("reqMethod_msg", msg1);
        map.put("annotation_msg", msg);
        map.put("hel1o", hello);
        map.put("wor1d", world);
        map.put("message", message);
        return map;
    }

}
