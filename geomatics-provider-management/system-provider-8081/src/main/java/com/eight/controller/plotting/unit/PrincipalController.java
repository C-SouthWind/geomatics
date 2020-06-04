package com.eight.controller.plotting.unit;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.plotting.unit.Principal;
import com.eight.model.plotting.unit.Unit;
import com.eight.redis.RedisService;
import com.eight.service.plotting.unit.PrincipalService;
import com.eight.service.plotting.unit.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/29 17:22
 * @params :  PrincipalController
 */
@RequestMapping("/plotting")
@RestController
public class PrincipalController extends BaseController {
    @Autowired
    public PrincipalService principalService;

    @Autowired
    private RedisService redisService;

    /**
    * @Description: 查询法人信息
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/29
    */
    @PostMapping("/unit/selectPrincipal")
    public ResultData selectPrincipal(){
        List<Principal> principal = principalService.selectPrincipal(redisService);
        if (null == principal) {
            return selectFailed();
        }
        return selectSuccess(principal);
    }
}
