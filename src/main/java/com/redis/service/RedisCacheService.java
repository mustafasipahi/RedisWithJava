package com.redis.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    @Cacheable(cacheNames = "test_cache_")
    public String longtimeReturnMethod() throws InterruptedException {
        Thread.sleep(5000);
        return "Method running..";
    }

    @CacheEvict(cacheNames = "test_cache_")
    public String cleanCache() throws InterruptedException {
        return "Cache cleaned";
    }
}
