package com.eight.service.plotting.unit;

import com.eight.mapper.plotting.unit.PrincipalMapper;
import com.eight.model.plotting.unit.Principal;
import com.eight.model.plotting.unit.Unit;
import com.eight.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/29 17:21
 * @params :  PrincipalService
 */
@Service
public class PrincipalService {
    @Autowired
    private PrincipalMapper principalMapper;
    /**
    * @Description: 查询法人信息
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/29
    */
    public List<Principal> selectPrincipal(RedisService redisService){
        List<Principal> principal = principalMapper.selectAll();
        if (null!=principal && principal.size()>0) {
            return principal;
        }
        return null;
    }
}
