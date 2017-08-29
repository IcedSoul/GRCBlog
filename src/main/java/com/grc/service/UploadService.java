package com.grc.service;

import com.grc.domain.Upload;
import com.grc.utils.Response;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
public interface UploadService {
    List<Upload> getUserUpload(Integer userId);
    List<Upload> getAllUpload();
    Upload getUpload(Integer fileId);
    void addUpload(Upload upload);
    void updateUpload(Upload upload);
    void deleteUpload(Integer fileId);
    Response uploadFile(MultipartFile fileUpload, Integer userId);
}
