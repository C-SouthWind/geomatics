package com.eight.controller.home;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.home.Mappingunit;
import com.eight.model.login.User;
import com.eight.redis.RedisService;
import com.eight.service.home.MappingunitService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/22 15:25
 * @params :  MappingunitController
 */
@RequestMapping("/mappingunit")
@RestController
public class MappingunitController extends BaseController {
    @Autowired
    public MappingunitService mappingunitService;

    @Autowired
    private RedisService redisService;

    
    /** 
    * @Description:  
    * @Param:  查询测绘单位
    * @return:  
    * @Author: hxy 
    * @Date: 2020/5/22 
    */

    @GetMapping("/selectMappingunit")
    public ResultData selectMappingunit(@RequestParam Map map){
        List<Mappingunit> mappingunit = mappingunitService.selectMappingunit(map, redisService);
        if (null == mappingunit) {
            return selectFailed();
        }
        return selectSuccess(mappingunit);
    }

}
