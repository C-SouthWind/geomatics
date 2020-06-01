package com.eight.controller.plotting.unit;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.plotting.unit.Equipment;
import com.eight.model.plotting.unit.SpecialPost;
import com.eight.redis.RedisService;
import com.eight.service.plotting.unit.SpecialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/30 13:43
 * @params :  SpecialPostController
 */
@RequestMapping("/plotting/unit")
@RestController
public class SpecialPostController extends BaseController {
    @Autowired
    public SpecialPostService specialPostService;

    @Autowired
    private RedisService redisService;

    /**
    * @Description: 查询特殊岗位
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/30
    */
    @PostMapping("/selectSpecialPost")
    public ResultData selectSpecialPost(){
        List<SpecialPost> specialpost = specialPostService.selectSpecialPost(redisService);
        if (null == specialpost) {
            return selectFailed();
        }
        return selectSuccess(specialpost);
    }
}
