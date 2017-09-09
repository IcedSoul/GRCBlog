package com.grc.repository;

import com.grc.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findByUserId(Integer userId);
    List<Blog> findByUserIdAndClassifyId(Integer userId,Integer classifyId);
    @Query("select b from Blog b where title like :keyWord or tags like :keyWord or blogContent like :keyWord")
    List<Blog> findByTitleLikeOrTagsLikeOrBlogContentLike(String keyWord);
}
