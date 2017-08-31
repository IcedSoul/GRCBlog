package com.grc.controller;


import com.alibaba.fastjson.JSONArray;
import com.grc.domain.Upload;
import com.grc.service.UploadService;
import com.grc.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14437 on 2017/6/25.
 */
@RestController
@EnableAutoConfiguration
public class UploadController {

    @Autowired
    UploadService uploadService;

    /**
     * 获取用户所有上传记录
     * @param userId
     * @return
     */
    @PostMapping(value = "/getUserUpload")
    public Map<String,Object> getUserUpload(@RequestParam("userId")Integer userId){
        String result = "";
        List<Upload> uploadList = uploadService.getUserUpload(userId);
        result = JSONArray.toJSONString(uploadList);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("uploads",result);
        return response;
    }

    /**
     * 获取所有上传记录
     * @return
     */
    @GetMapping(value = "/getAllUpload")
    public Map<String,Object> getAllUpload(){
        String result = "";
        List<Upload> uploadList = uploadService.getAllUpload();
        result = JSONArray.toJSONString(uploadList);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("uploads",result);
        return response;
    }

    /**
     * 根据Id获取上传记录
     * @param fileId
     * @return
     */
    @PostMapping(value = "/getUpload")
    public Response getUpload(@RequestParam("fileId")Integer fileId){
        return uploadService.getUpload(fileId);
    }

    /**
     * 添加一条上传记录
     * @param userId
     * @param filePath
     * @param name
     * @param remark
     * @param itClassifyId
     * @param keyword
     * @param score
     * @return
     */
    @PostMapping(value = "/addUpload")
    public Response addUpload(@RequestParam("userId")Integer userId,
                                        @RequestParam("filePath")String filePath,
                                        @RequestParam("name")String name,
                                        @RequestParam("remark")String remark,
                                        @RequestParam("itClassifyId")Integer itClassifyId,
                                        @RequestParam("keyword")String keyword,
                                        @RequestParam("score")Integer score){
        return uploadService.addUpload(userId,filePath,name,remark,itClassifyId,keyword,score);
    }

    /**
     * 更新一条上传记录
     * @param fileId
     * @param userId
     * @param filePath
     * @param name
     * @param remark
     * @param itClassifyId
     * @param keyword
     * @param downNum
     * @param score
     * @return
     */
    @PostMapping(value = "/updateUpload")
    public Map<String,Object> updateUpload(@RequestParam("userId")Integer fileId,
                                           @RequestParam("userId")Integer userId,
                                           @RequestParam("filePath")String filePath,
                                           @RequestParam("name")String name,
                                           @RequestParam("remark")String remark,
                                           @RequestParam("itClassifyId")Integer itClassifyId,
                                           @RequestParam("keyword")String keyword,
                                           @RequestParam("downNum")Integer downNum,
                                           @RequestParam("score")Integer score){
        Upload upload = new Upload();
        upload.setUserId(userId);
        upload.setFilePath(filePath);
        upload.setName(name);
        upload.setRemark(remark);
        upload.setItClassifyId(itClassifyId);
        upload.setKeyword(keyword);
        upload.setDownNum(downNum);
        upload.setDownNum(0);
        upload.setScore(score);
        uploadService.updateUpload(upload);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("updateResult","success");
        return response;
    }

    /**
     * 删除上传记录
     * @param fileId
     * @return
     */
    @PostMapping(value = "/deleteUpload")
    public Map<String,Object> deleteUpload(@RequestParam("fileId")Integer fileId){
        String result = "";
        uploadService.deleteUpload(fileId);
        result = "success";
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("deleteResult",result);
        return response;
    }

    @PostMapping(value = "/uploadFile")
    public Response uploadFile(@RequestParam MultipartFile fileUpload, Integer userId){
        return uploadService.uploadFile(fileUpload,userId);
    }

    @GetMapping(value = "/downloadFile")
    public ResponseEntity<byte[]> downloadFile(@RequestParam("userId")Integer userId,
                                                 @RequestParam("fileId")Integer fileId){
        return uploadService.downloadFile(userId,fileId);
    }

}
