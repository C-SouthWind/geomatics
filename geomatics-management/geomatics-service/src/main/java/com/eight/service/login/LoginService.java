package com.eight.service.login;


import com.eight.mapper.login.UserMapper;
import com.eight.model.login.User;
import com.eight.redis.RedisService;
import com.eight.utils.GainDate;
import com.eight.utils.IDUtils;
import com.eight.vo.TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.eight.staticstatus.RedisProperties.*;


/**
 * @author ：chj
 * @date ：Created in 2020/5/15 18:48
 * @params :
 */
@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    /** 方法描述 
    * @Description: 执行登录操作
    * @Param: [user, redisService]
    * @return: com.chj.vo.TokenVo
    * @Author: chj
    * @Date: 2020/5/15
    */
    public TokenVo doLogin(User user, RedisService redisService) {
        TokenVo tokenVo = new TokenVo();
        tokenVo.setIfSuccess(false);
        if (null != user) {
            User u = userMapper.userSelectByUsernameAndUserPassword(user);
            //User u = userMapper.selectOne(user);
            if (null != u) {
                String token = IDUtils.getUUID();
                u.setToken(token);
	            u.setCreateTime(GainDate.getDate());
               int updateResult = userMapper.updateByPrimaryKey(u);
                System.out.println("updateResult-------------"+updateResult);
                if (updateResult > 0) {
                    try {
                        String setResult = redisService.set(String.valueOf(u.getId()), token, XX, NX, 1800);
                        if ("OK".equals(setResult.toUpperCase()) || "1".equals(setResult)) {
                            return tokenVo.setIfSuccess(true).setToken(token).setRedisKey(String.valueOf(u.getId()));
                        } else {
                            System.out.println("Redis存储Token失败");
                        }
                    }catch (Exception e){
                        return tokenVo.setIfSuccess(true).setToken(token).setRedisKey(null);
                    }
                }
            }
        }
        return tokenVo;
    }
}
