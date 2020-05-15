package com.eight.redis;

import com.eight.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import static com.eight.staticstatus.RedisProperties.*;

/**
 * @author ：chj
 * @date ：Created in 2020/5/14 15:51
 * @params :
 */
@Service
public class RedisService<T> {
    @Autowired
    private JedisCluster jedisCluster;

    /** 方法描述 
    * @Description: 向redis中保存数据(并设置时效时间)
    * @Param: [key, value, nxxx, expx, seconds]
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/5/15
    */
    public String set(String key,T value,String nxxx,String expx ,Integer seconds) {
        if (null != seconds && 0 < seconds && (NX.equals(nxxx) || XX.equals(nxxx)) && (EX.equals(expx) || PX.equals(expx))) {
            return jedisCluster.set(key, JSONUtil.toJsonString(value), nxxx, expx, seconds);
        } else { //不需要设置失效时间
            if (NX.equals(nxxx)) {
                return String.valueOf(jedisCluster.setnx(key, JSONUtil.toJsonString(value)));
            } else if (XX.equals(nxxx)) {
                return jedisCluster.set(key, JSONUtil.toJsonString(value));
            }
        }
        return NO;
    }
}





















