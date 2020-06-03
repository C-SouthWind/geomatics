package com.eight.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 17:39
 * @params :
 */
public class FTPUtils {

   private FTPUtils(){}

   /** 方法描述
   * @Description: ftp文件上传工具类
   * @Param: [host, port, username, password, filePath, basePath, fileName, input]
   * @return: java.lang.Boolean
   * @Author: chj
   * @Date: 2020/5/15
   */
   public static Boolean uploadFile(String host, Integer port, String username, String password,
                                     String filePath, String basePath, String fileName, InputStream input){

       String tmpPath="";
       FTPClient ftp = new FTPClient();
       try {
          ftp.connect(host,port);
            ftp.login(username, password);
           int reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
               ftp.disconnect();
               return false;
           }
           if (!ftp.changeWorkingDirectory(basePath+filePath)) {
               String[] dirs = filePath.split("/");
                tmpPath=basePath;
               for(String dir : dirs){
                   if (null == dir || "".equals(dir)) {
                       continue;
                   }
                   tmpPath += "/"+ dir;
                   if (!ftp.changeWorkingDirectory(tmpPath)) {
                      if (!ftp.makeDirectory(tmpPath)) {
                           return false;
                       }else {
                           System.out.println(ftp.changeWorkingDirectory(tmpPath));
                       }
                   }
               }
           }
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
           if (!ftp.storeFile(fileName,input)) {
               return false;
           }
          input.close();
           ftp.logout();
       }catch (IOException e){
           e.printStackTrace();
       }finally {
           if (ftp.isConnected()) {
               try{
                   ftp.disconnect();
               }catch (IOException e){
                   e.printStackTrace();
               }
           }
       }
       return true;
   }

}

