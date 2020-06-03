package com.eight.config;

import com.eight.properties.RedisClusterProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：chj
 * @date ：Created in 2020/5/14 15:43
 * @params :
 */
@Configuration
public class RedisClusterConfig {
    @Autowired
    private RedisClusterProperties redisClusterProperties;

    @Bean
    public JedisCluster jedisCluster(){
        String nodes = redisClusterProperties.getNodes();
        String[] nodeArr = nodes.split(",");
        Set<HostAndPort> hostAndPortHashSet = new HashSet<HostAndPort>();

        for ( String node: nodeArr) {
            String[] hostPort = node.split(":");
            HostAndPort hostAndPort = new HostAndPort(hostPort[0], Integer.parseInt(hostPort[1]));
            hostAndPortHashSet.add(hostAndPort);
        }
        JedisCluster jedisCluster = new JedisCluster(hostAndPortHashSet, redisClusterProperties.getCommandTimeout(), redisClusterProperties.getMaxAttempts());
        return jedisCluster;
    }













}
