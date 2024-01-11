package com.jdjm1.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @version v1.0
 * @Author zhy
 * Description 默认
 */
@RestController
public class SessionController {

    @RequestMapping(path = "/login")
    public String login(String uname, HttpSession httpSession) {
        httpSession.setAttribute("name", uname);
        return "欢迎登录：" + uname;
    }

    @RequestMapping("time")
    public String showTime(HttpSession session) {
        return session.getAttribute("name") + " ，当前时间为：" + LocalDateTime.now();
    }

    @RequestMapping("name")
    public String showName(HttpServletRequest request) {
        return "当前登录用户：" + request.getSession().getAttribute("name");
    }

    @RequestMapping(path = "logout")
    public String logout(HttpSession httpSession) {
        // 注销当前的session
        httpSession.invalidate();
        return "登出成功";
    }

    @GetMapping("/example")
    public ResponseEntity<String> example() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "hhh");
        String responseBody = "Hello, World!";
        return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
    }

    @GetMapping("/example1")
    public String example1() {
        return "Hello, World!";
    }
}
