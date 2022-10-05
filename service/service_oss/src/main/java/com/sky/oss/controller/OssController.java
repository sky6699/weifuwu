package com.sky.oss.controller;

import com.sky.commonutils.R;
import com.sky.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(description="上传文件")
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    @ApiOperation(value = "上传文件")
    @PostMapping("/uploadOssFile")
    public R uploadOssFile(MultipartFile file){
        //获取上传文件
        //返回上传到0ss的路径
        String url=ossService.uploadFileAvatar(file);

        return R.ok().data("url",url);

    }
}
