package com.zero.springframework.aspect.service.impl;

import com.zero.springframework.aspect.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String name) {
        String sss = "hello," + name;
        log.info(sss);
        return sss;
    }

}
