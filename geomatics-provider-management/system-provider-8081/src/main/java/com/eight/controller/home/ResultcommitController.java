package com.eight.controller.home;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.home.Resultcommit;
import com.eight.redis.RedisService;
import com.eight.service.home.ResultcommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author ：hxy
 * @date ：Created in 2020/5/26 15:32
 * @params :  ResultcommitController
 */
@RequestMapping("/resultcommit")
@RestController
public class ResultcommitController extends BaseController {
    @Autowired
    public ResultcommitService resultcommitService;

    @Autowired
    private RedisService redisService;

    /**
    * @Description: 查询测绘成果
    * @Param:
    * @return:
    * @Author: hxy
    * @Date: 2020/5/26
    */
    @PostMapping("/selectResultcommit")
    public ResultData selectResultcommit(@RequestParam Map map){
        List<Resultcommit> resultcommit = resultcommitService.selectResultcommit(map, redisService);
        if (null == resultcommit) {
            return selectFailed();
        }
        return selectSuccess(resultcommit);
    }
}
