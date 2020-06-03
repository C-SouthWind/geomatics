package com.eight.controller.plotting.unit;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.plotting.unit.Principal;
import com.eight.model.plotting.unit.Technicist;
import com.eight.redis.RedisService;
import com.eight.service.plotting.unit.TechnicistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/29 20:50
 * @params :  TechnicistController
 */
@RequestMapping("/plotting/unit")
@RestController
public class TechnicistController extends BaseController {
    @Autowired
    public TechnicistService technicistService;

    @Autowired
    private RedisService redisService;

    /**
    * @Description: 查询技术人员信息
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/29
    */
    @PostMapping("/selectTechnicist")
    public ResultData selectTechnicist(){
        List<Technicist> technicist = technicistService.selectTechnicist(redisService);
        if (null == technicist) {
            return selectFailed();
        }
        return selectSuccess(technicist);
    }
}
