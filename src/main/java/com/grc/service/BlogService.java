package com.grc.service;

import com.grc.entity.Blog;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface BlogService {
    List<Blog> getUserBlog(Integer userId);
    Blog getBlog(Integer blogId);
    void addBlog(Blog blog);
    void deleteBlog(Integer blogId);
}
