package com.gxf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by GuanXF on 2018/3/5.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        System.out.println("userAgent: " + userAgent);

        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/redirect")
    public String redirec(){
        return "redirect:/https://www.google.com";
    }
}
