package com.grc.repository;

import com.grc.domain.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface UploadRepository extends JpaRepository<Upload,Integer> {
    public List<Upload> findByUserId(Integer userId);
    @Query("select u from Upload u where filePath like :keyWord or name like :keyWord or keyWord like :keyWord or remark like :keyWord")
    public List<Upload> findByFilePathLikeOrNameLikeOrKeywordLikeOrRemarkLike(@Param("keyWord")String keyWord);
}
