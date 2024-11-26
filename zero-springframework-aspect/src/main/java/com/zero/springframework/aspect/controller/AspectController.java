package com.zero.springframework.aspect.controller;

import com.zero.springframework.aspect.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/aspect")
public class AspectController {

    TestService testService;

    @Autowired
    public AspectController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/hello")
    public Map<String, Object> showHelloWorld() {
        Map<String, Object> map = new HashMap<>();
        String str = testService.sayHello("liming");
        map.put("msg", str);
        return map;
    }

}