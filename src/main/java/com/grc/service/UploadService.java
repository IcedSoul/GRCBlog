package com.grc.service;

import com.grc.entity.Upload;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
public interface UploadService {
    public List<Upload> getUserUpload(Integer userId);
    public List<Upload> getAllUpload();
    public Upload getUpload(Integer fileId);
    public void addUpload(Upload upload);
    public void updateUpload(Upload upload);
    public void deleteUpload(Integer fileId);

}
