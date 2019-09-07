package com.react.zpserver;

import com.react.zpserver.config.RedisFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZpServerApplicationTests {

    @Resource
    private RedisFactory redisFactory;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
        System.out.printf(redisFactory.toString());
    }
    @Test
    public void testRedis(){
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
    }
}
