package com.redis.controller;

import com.redis.service.RedisCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisCacheController {

    private final RedisCacheService redisCacheService;
    private int count = 0;

    public RedisCacheController(RedisCacheService redisCacheService) {
        this.redisCacheService = redisCacheService;
    }

    @GetMapping("/test")
    public String cacheTest() throws InterruptedException {

        if (count > 5) {
            count = 0;
            return redisCacheService.cleanCache();
        }
        count++;

        return redisCacheService.longtimeReturnMethod();
    }
}
