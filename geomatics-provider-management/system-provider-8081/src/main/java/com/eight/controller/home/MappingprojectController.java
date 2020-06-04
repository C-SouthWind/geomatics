package com.eight.controller.home;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.home.Mappingproject;
import com.eight.model.home.Mappingunit;
import com.eight.model.login.User;
import com.eight.model.manage.Dict;
import com.eight.redis.RedisService;
import com.eight.service.home.MappingprojectService;
import com.eight.utils.NotEmpty;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/25 15:30
 * @params :  MappingprojectController
 */
@RequestMapping("/mappingproject")
@RestController
public class MappingprojectController extends BaseController {
    @Autowired
    public MappingprojectService mappingprojectService;

    @Autowired
    private RedisService redisService;

    /**
    * @Description: 查询测绘项目
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/25
    */
    @PostMapping("/selectMappingproject")
    public ResultData selectMappingproject(@RequestParam Map map){
        List<Mappingproject> mappingprojects = mappingprojectService.selectMappingproject(map, redisService);
        if (null == mappingprojects) {
            return selectFailed();
        }
        return selectSuccess(mappingprojects);
    }
}
