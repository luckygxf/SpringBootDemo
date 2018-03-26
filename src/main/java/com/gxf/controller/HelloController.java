package com.gxf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua_parser.Client;
import ua_parser.Parser;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by GuanXF on 2018/3/5.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        System.out.println("userAgent: " + userAgent);
        try {
            Parser parser = new Parser();
            Client c = parser.parse(userAgent);
            System.out.println(c.userAgent.family); // => "Mobile Safari"
            System.out.println(c.userAgent.major);  // => "5"
            System.out.println(c.userAgent.minor);  // => "1"

            System.out.println(c.os.family);        // => "iOS"
            System.out.println(c.os.major);         // => "5"
            System.out.println(c.os.minor);         // => "1"

            System.out.println(c.device.family);    // => "iPhone"
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Greetings from Spring Boot!";
    }
}
