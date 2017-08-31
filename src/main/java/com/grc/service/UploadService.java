package com.grc.service;

import com.grc.domain.Upload;
import com.grc.utils.Response;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
public interface UploadService {
    List<Upload> getUserUpload(Integer userId);
    List<Upload> getAllUpload();
    Response getUpload(Integer fileId);
    Response addUpload(Integer userId,String filePath,String name,String remark,Integer itClassifyId,String keyword,Integer score);
    void updateUpload(Upload upload);
    void deleteUpload(Integer fileId);
    Response uploadFile(MultipartFile fileUpload, Integer userId);
    ResponseEntity<byte[]> downloadFile(Integer userId,Integer fileId);
}
