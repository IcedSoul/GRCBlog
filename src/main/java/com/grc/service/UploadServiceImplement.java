package com.grc.service;

import com.grc.domain.Upload;
import com.grc.repository.UploadRepository;
import com.grc.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
@Service
public class UploadServiceImplement implements UploadService {

    @Autowired
    UploadRepository uploadRepository;

    @Override
    public List<Upload> getUserUpload(Integer userId) {
        return uploadRepository.findByUserId(userId);
    }

    @Override
    public List<Upload> getAllUpload() {
        return uploadRepository.findAll();
    }

    @Override
    public Upload getUpload(Integer fileId) {
        return uploadRepository.findOne(fileId);
    }

    @Override
    public void addUpload(Upload upload) {
        uploadRepository.save(upload);
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
                String fileRealPath = "http://localhost:8080/GRCBlog/static/file/"+userId;
                String fileName = fileUpload.getName();
                File fileFolder = new File(fileRealPath);
                if(!fileFolder.exists()){
                    fileFolder.mkdirs();
                }
                File file = new File(fileFolder,fileName);
                fileUpload.transferTo(file);
                return new Response("0","上传成功","");
            }
        }catch(Exception e){
            return new Response("-1","上传失败","");
        }
        return new Response("-1","上传失败","");
    }
}
