package com.eight.service;


import com.eight.properties.FTPProperties;
import com.eight.utils.DateUtils;
import com.eight.utils.FTPUtils;
import com.eight.utils.FileNameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * @author ：chj
 * @date ：Created in 2020/5/23 18:45
 * @params :
 */
@Service
public class UploadService {

    @Autowired
    private FTPProperties ftpProperties;

   /** 方法描述
   * @Description: ftp文件上传
   * @Param: [file]
   * @return: java.lang.Boolean
   * @Author: chj
   * @Date: 2020/5/29
   */
    public Boolean upload(MultipartFile file) {
        // 1.获取原始文件的名称
        String oldFileName = file.getOriginalFilename();
        // 2.获取新的文件名
        String newFileName = FileNameUtils.getFileName();
        // 3.获取到文件名
        newFileName = newFileName + oldFileName.substring(oldFileName.lastIndexOf("."));
        try {
            // 4.日期格式化后的数据
            String filePath = DateUtils.formatDate(new Date(), "yyyy/MM/dd");
            return FTPUtils.uploadFile(ftpProperties.getHost(), ftpProperties.getPort(), ftpProperties.getUsername(),
                    ftpProperties.getPassword(), filePath, ftpProperties.getBasePath(), newFileName, file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}


















