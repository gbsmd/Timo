package com.linln.common.utils;

import com.linln.BootApplication;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest(classes = BootApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisTest {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Test
    public void test() {
        redisTemplate.opsForValue().set("key", "xxx");

        System.out.println(redisTemplate.opsForValue().get("key"));

    }
}
