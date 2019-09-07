package com.react.zpserver.config;

import com.react.zpserver.model.UserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.*;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Configuration
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;



    /**
     * 批量删除对应的value
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }
    /**
     * 删除对应的value
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }
    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object value){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key,hashKey,value);
    }

    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGet(String key, Object hashKey){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key,hashKey);
    }

    /**
     * 注册
     * 验证用户名是否存在
     * @param username username
     * @return boolean
     */
    public boolean userNameIsExist(String hashKey, String username){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        if(hash == null){
            return false;
        }
        return hash.hasKey(hashKey,username);
    }

    /**
     * 删除用户信息
     * @param hashKey  缓存key
     * @param username 用户名
     * @return boolean
     */
    public boolean delUserData(String hashKey, String username){
        return !StringUtils.isEmpty(redisTemplate.opsForHash().delete(hashKey,username));
    }

    /**
     * 根据用户名和登录密码判断用户是否存在
     * @param hashKey hashKey
     * @param username username
     * @param password password
     * @return UserDo
     */
    public UserDo getUserData(String hashKey,String username,String password){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        if(hash == null){
            return null;
        }

        UserDo userDo = (UserDo) hash.get(hashKey,username);
        if(userDo == null){
            return null;
        }
        return userDo.getPassword().equalsIgnoreCase(password) ? userDo : null;
    }


    /**
     * 列表添加
     * @param k
     * @param v
     */
    public void lPush(String k,Object v){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k,v);
    }

    /**
     * 列表获取
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<Object> lRange(String k, long l, long l1){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k,l,l1);
    }

    /**
     * 集合添加
     * @param key
     * @param value
     */
    public void add(String key,Object value){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key,value);
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key,Object value,double scoure){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key,value,scoure);
    }

    /**
     * 有序集合获取
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> rangeByScore(String key, double scoure, double scoure1){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }
}
