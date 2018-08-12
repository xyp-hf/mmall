package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
* 文件上传接口
* @since 2018年06月26日
* @author Yupeng.Xu
* @update Yupeng.Xu
*/
public interface IFileService {
    /**
    * 文件常常
    * @since 2018年08月05日
    * @author Yupeng.Xu
    * @update Yupeng.Xu
    * @param file 文件
    * @param path 上传路径
    */
    String upload(MultipartFile file, String path);
}
