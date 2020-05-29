package com.eight.controller;

import com.eight.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：chj
 * @date ：Created in 2020/5/29 17:09
 * @params :
 */
@RestController
public class UploadController {


    @Autowired
    private UploadService uploadService;

     /** 方法描述
     * @Description: ftp文件上传
     * @Param: [file]
     * @return: java.lang.Boolean
     * @Author: chj
     * @Date: 2020/5/29
     */
    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean uploadFile(@RequestBody MultipartFile file) {
        return uploadService.upload(file);
    }

}
