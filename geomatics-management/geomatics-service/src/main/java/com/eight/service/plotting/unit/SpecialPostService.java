package com.eight.service.plotting.unit;

import com.eight.mapper.plotting.unit.SpecialPostMapper;
import com.eight.model.plotting.unit.Equipment;
import com.eight.model.plotting.unit.SpecialPost;
import com.eight.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/30 13:42
 * @params :  SpecialPostService
 */
@Service
public class SpecialPostService {
    @Autowired
    private SpecialPostMapper specialPostMapper;
    
    /** 
    * @Description: 查询 特殊岗位
    * @Param:  
    * @return:  
    * @Author: hxy 
    * @Date: 2020/5/30 
    */
    public List<SpecialPost> selectSpecialPost(RedisService redisService){
        List<SpecialPost> specialpost = specialPostMapper.selectAll();
        if (null!=specialpost && specialpost.size()>0) {
            return specialpost;
        }
        return null;
    }
}
