package com.grc.service;

import com.alibaba.fastjson.JSON;
import com.grc.domain.Upload;
import com.grc.repository.UploadRepository;
import com.grc.utils.Response;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
@Service
@Log
public class UploadServiceImplement implements UploadService {

    @Autowired
    UploadRepository uploadRepository;

    @Value("${web.upload-path}")
    private String path;

    @Override
    public List<Upload> getUserUpload(Integer userId) {
        return uploadRepository.findByUserId(userId);
    }

    @Override
    public List<Upload> getAllUpload() {
        return uploadRepository.findAll();
    }

    @Override
    public Response getUpload(Integer fileId) {
        String result = "";
        Upload upload = uploadRepository.findOne(fileId);
        if(upload!=null)
            return new Response("0","获取文件信息成功", JSON.toJSONString(upload));
        else
            return new Response("-1","文件不存在", "");
    }

    @Override
    public Response addUpload(Integer userId,String filePath,String name,String remark,Integer itClassifyId,String keyword,Integer score) {
        Upload upload = new Upload();
        upload.setUserId(userId);
        upload.setFilePath(filePath);
        upload.setName(name);
        upload.setRemark(remark);
        upload.setItClassifyId(itClassifyId);
        upload.setKeyword(keyword);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        upload.setUpTime(timestamp);
        upload.setDownNum(0);
        upload.setScore(score);
        try {
            upload = uploadRepository.save(upload);
            return new Response("0","新增上传信息成功",JSON.toJSONString(upload));
        }catch (Exception e){
            return new Response("0","新增上传信息失败",JSON.toJSONString(upload));
        }
    }

    @Override
    public void updateUpload(Upload upload) {
        uploadRepository.save(upload);
    }

    @Override
    public void deleteUpload(Integer fileId) {
        uploadRepository.delete(fileId);
    }

    @Override
    public Response uploadFile(MultipartFile fileUpload, Integer userId) {
        try{
            if(fileUpload != null && !fileUpload.isEmpty()) {
                String fileName = fileUpload.getOriginalFilename();
                File fileFolder = new File(path+String.valueOf(userId)+"/");
                if(!fileFolder.exists()){
                    fileFolder.mkdirs();
                }
                File file = new File(fileFolder,fileName);
                fileUpload.transferTo(file);
                return new Response("0","文件上传成功",file.getAbsolutePath());
            }
        }catch(Exception e){
            return new Response("-1","文件上传失败","");
        }
        return new Response("-1","文件上传失败","");
    }

    @Override
    public ResponseEntity<byte[]> downloadFile(Integer userId,Integer fileId) {
        log.info("\n********** 下载文件 : ************\n");
//        String filePath = uploadRepository.findOne(fileId).getFilePath();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
//        headers.add("Pragma", "no-cache");
//        headers.add("Expires", "0");
//        headers.add("charset", "utf-8");
//        File file = new File(filePath);
//        FileSystemResource fileSystemResource = new FileSystemResource(file);
//
//        return new ResponseEntity<Resource>(fileSystemResource, headers, HttpStatus.OK);
        try {
            String filePath = uploadRepository.findOne(fileId).getFilePath();
            File file=new File(filePath);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", file.getName());
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                    headers, HttpStatus.CREATED);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
