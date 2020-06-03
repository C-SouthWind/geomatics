package com.eight.controller.manage;

import com.eight.base.BaseController;
import com.eight.base.ResultData;
import com.eight.model.manage.Dict;
import com.eight.redis.RedisService;
import com.eight.service.manage.DictService;
import com.eight.utils.NotEmpty;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/23 15:00
 * @params :    系统管理  字典管理
 */
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {
    @Autowired
    private DictService dictService;
    @Autowired
    private RedisService redisService;

    /** 方法描述
    * @Description: 分页条件查询
     *                  系统管理--->字典管理       dict表
    * @Param: [map]
    * @return: com.eight.base.ResultData
    * @Author: chj
    * @Date: 2020/5/23
    */
    @PostMapping("/dictSelectPage")
    public ResultData dictSelectPage(@RequestParam Map map){
        PageInfo<Dict> dictPageInfo = dictService.dictSelectPage(map,redisService);
        return null != dictPageInfo ? selectSuccess(dictPageInfo) : selectFailed();
    }

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      新增dict表
     * @Param: [dict]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dictInsertByDict")
    public ResultData dictInsertByDict(@RequestBody Dict dict){
        Integer integer = dictService.dictInsertByDict(dict);
        return NotEmpty.integerNotEmpty(integer) ? insertSuccess("新增"+integer+"条数据") : insertFailed();
    }

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      删除dict表数据
     * @Param: [dict]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dictDeleteByDict")
    public ResultData dictDeleteByDict(@RequestBody Dict dict){
        Integer integer = dictService.dictDeleteByDict(dict);
        return NotEmpty.integerNotEmpty(integer) ? deleteSuccess("删除"+integer+"条数据") : deleteFailed();
    }

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      查询dict表单个数据
     * @Param: [dict]
     * @return: java.lang.Integer
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dictSelectOneByDict")
    public ResultData dictSelectOneByDict(@RequestBody Dict dict){
        Dict dict1 = dictService.dictSelectOneByDict(dict);
        return NotEmpty.objectNotEmpty(dict1) ? selectSuccess(dict) : selectFailed();
    }

    /** 方法描述
     * @Description: 系统管理--->字典管理
     *                      修改dict表单个数据
     * @Param: [dict]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/23
     */
    @PostMapping("/dictUpdateByDict")
    public ResultData dictUpdateByDict(@RequestBody Dict dict){
        Integer integer = dictService.dictUpdateByDict(dict);
        return NotEmpty.integerNotEmpty(integer) ? updateSuccess("修改"+integer+"条数据") : updateFailed();

    }


}
