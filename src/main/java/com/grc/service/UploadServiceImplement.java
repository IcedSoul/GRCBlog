package com.grc.service;

import com.grc.entity.Upload;
import com.grc.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
