package com.grc.repository;

import com.grc.entity.Upload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface UploadRepository extends JpaRepository<Upload,Integer> {
    public List<Upload> findByUserId(Integer userId);
}
