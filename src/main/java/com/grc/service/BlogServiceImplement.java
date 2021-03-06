package com.grc.service;

import com.grc.domain.Blog;
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
    public List<Blog> getAllBlog(Integer userId) {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> getUserBlog(Integer userId) {
        return blogRepository.findByUserId(userId);
    }

    @Override
    public List<Blog> getUserClassifyBlog(Integer userId, Integer classifyId) {
        return blogRepository.findByUserIdAndClassifyId(userId,classifyId);
    }

    @Override
    public Blog getBlog(Integer blogId) {
        return blogRepository.findOne(blogId);
    }

    @Override
    public Blog addBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Integer blogId) {
        blogRepository.delete(blogId);
    }
}
