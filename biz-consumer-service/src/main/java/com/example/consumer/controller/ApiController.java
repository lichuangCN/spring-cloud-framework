package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lichuang
 * @date 2021/05/13
 * @description
 */
@RestController
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/user/query")
    public String query() {
        return restTemplate.getForEntity("http://biz-service/user/query", String.class).getBody();
    }
}
