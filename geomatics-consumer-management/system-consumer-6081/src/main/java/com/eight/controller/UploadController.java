package com.eight.controller;

import com.eight.service.EightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：chj
 * @date ：Created in 2020/5/29 17:14
 * @params :
 */
@RestController
@Api(value = "文件上传", tags = "文件上传的接口")
public class UploadController {

    @Autowired
    private EightService eightService;

    /** 方法描述
     * @Description: 文件上传
     * @Param: [file]
     * @return: java.lang.Boolean
     * @Author: chj
     * @Date: 2020/5/29
     */
    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "实现文件上传", notes = "单文件上传接口")
    Boolean uploadFile(@RequestBody MultipartFile file){
        return eightService.uploadFile(file);
    }

}
