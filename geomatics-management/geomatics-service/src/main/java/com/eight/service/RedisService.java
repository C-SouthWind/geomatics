package com.eight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @author ：chj
 * @date ：Created in 2020/5/14 15:51
 * @params :
 */
@Service
public class RedisService {
    @Autowired
    private JedisCluster jedisCluster;
}
