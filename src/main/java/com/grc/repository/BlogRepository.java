package com.grc.repository;

import com.grc.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    public List<Blog> findByUserId(Integer userId);
}
