package com.grc.service;

import com.grc.domain.Blog;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface BlogService {
    List<Blog> getAllBlog(Integer userId);
    List<Blog> getUserBlog(Integer userId);
    List<Blog> getUserClassifyBlog(Integer userId,Integer classifyId);
    Blog getBlog(Integer blogId);
    Blog addBlog(Blog blog);
    void deleteBlog(Integer blogId);
}
