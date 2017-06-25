package com.grc.service;

import com.grc.entity.Blog;
import com.grc.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
@Service
public class BlogServiceImplement implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> getUserBlog(Integer userId) {
        return blogRepository.findByUserId(userId);
    }

    @Override
    public Blog getBlog(Integer blogId) {
        return blogRepository.findOne(blogId);
    }

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Integer blogId) {
        blogRepository.delete(blogId);
    }
}
