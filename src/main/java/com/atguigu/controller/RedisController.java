package com.atguigu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redis")
public class RedisController {
	
	@Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 添加String的值
     *
     * @param k
     * @param v
     * @Description
     */
    public void set(String k, String v) {
        if (isEmpty(k)) {
            return;
        }
        redisTemplate.opsForValue().set(k, v);
    }

    /**
     * 获取String的值
     *
     * @param k
     * @Description
     */
    public String get(String k) {
        if (isEmpty(k)) {
            return null;
        }
        return redisTemplate.opsForValue().get(k);
    }

    public void del(String k) {
        if (isEmpty(k)) {
            return;
        }
        redisTemplate.opsForValue().get(k);
    }

    /**
     * 向Hash中添加值
     *
     * @param key   可以对应数据库中的表名
     * @param field 可以对应数据库表中的唯一索引
     * @param value 存入redis中的值
     */
    public void hset(String key, String field, String value) {
        if (key == null || "".equals(key)) {
            return;
        }
        redisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 从redis中取出值
     *
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field) {
        if (key == null || "".equals(key)) {
            return null;
        }
        return (String) redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 判断 是否存在 key 以及 hash key
     *
     * @param key
     * @param field
     * @return
     */
    public boolean hexists(String key, String field) {
        if (key == null || "".equals(key)) {
            return false;
        }
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    /**
     * 查询 key中对应多少条数据
     *
     * @param key
     * @return
     */
    public long hsize(String key) {
        if (key == null || "".equals(key)) {
            return 0L;
        }
        return redisTemplate.opsForHash().size(key);
    }

    /**
     * 删除
     *
     * @param key
     * @param field
     */
    public void hdel(String key, String field) {
        if (key == null || "".equals(key)) {
            return;
        }
        redisTemplate.opsForHash().delete(key, field);
    }

    /**
     * @Description 判断key是否为null
     * @Return
     */
    public Boolean isEmpty(String key) {
        if (key == null || "".equals(key)) {
            return true;
        }
        return false;
    }



}
