package com.eight.service;

import com.eight.model.home.Mappingunit;
import com.eight.model.login.User;
import com.eight.vo.TokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 20:32
 * @params :
 */
@FeignClient(value = "system-interface")
public interface EightService {

    /** 方法描述
     * @Description: 执行登录操作
     * @Param: [user]
     * @return: com.chj.vo.TokenVo
     * @Author: chj
     * @Date: 2020/5/15
     */
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user);

    /** 
    * @Description: 查询 测绘单位
    * @Param:  
    * @return:  
    * @Author: hxy 
    * @Date: 2020/5/23 
    */
    @GetMapping("/selectMappingunit")
    TokenVo selectMappingunit(@RequestBody Mappingunit mappingunit);
}
