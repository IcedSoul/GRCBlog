package com.grc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.grc.domain.Blog;
import com.grc.domain.User;
import com.grc.service.BlogService;
import com.grc.service.UserService;
import com.grc.utils.CommonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14437 on 2017/6/21.
 */
@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    /**
     *
     * @param userId
     * @return
     */
    @PostMapping(value = "/getAllBlogs")
    public Map<String,Object> getAllBlogs(@RequestParam("userId")Integer userId){
        String result = "";
        List<Blog> blogList = blogService.getAllBlog(userId);
        result = JSONArray.toJSONString(blogList);
        JSONArray blogs = JSON.parseArray(result);
        for(int i=0;i<blogs.size();i++){
            JSONObject blog = (JSONObject) blogs.get(i);
            Integer userId1 = Integer.valueOf(blog.get("userId").toString());
            String userName = userService.findUser(userId1).getUserName();
            blog.put("userName",userName);
            blog.put("img",userService.findUser(userId1).getImg());
        }
        result = blogs.toJSONString();
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("blogs",result);
        return response;
    }

    /**
     * 获取用户的所有博客
     * @param userId
     * @return
     */
    @PostMapping(value = "/getUserBlogs")
    public Map<String,Object> getUserBlogs(@RequestParam("userId")Integer userId){
        String result = "";
        List<Blog> blogList = blogService.getUserBlog(userId);
        result = JSONArray.toJSONString(blogList, SerializerFeature.UseSingleQuotes);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("blogs",result);
        return response;
    }

    /**
     * 获取用户某个分类的所有博客
     * @param userId
     * @return
     */
    @PostMapping(value = "/getUserClassifyBlogs")
    public Map<String,Object> getUserClassifyBlogs(@RequestParam("userId")Integer userId,
                                                   @RequestParam("classifyId")Integer classifyId){
        String result = "";
        List<Blog> blogList = blogService.getUserClassifyBlog(userId,classifyId);
        result = JSONArray.toJSONString(blogList, SerializerFeature.UseSingleQuotes);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("blogs",result);
        return response;
    }

    /**
     * 根据博客Id获取博客
     * @param blogId
     * @return
     */
    @PostMapping(value = "/getBlog")
    public Map<String,Object> getBlog(@RequestParam("blogId")Integer blogId){
        String result = "";
        Blog blog = blogService.getBlog(blogId);
        result = JSON.toJSONString(blog);
        JSONObject blog1 = JSON.parseObject(result);
        blog1.put("userName",userService.findUser(blog.getUserId()).getUserName());
        result = blog1.toJSONString();
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("blog",result);
        return response;
    }

    /**
     * 添加博客
     * @param userId
     * @param title
     * @param blogContent
     * @param classifyId
     * @param itClassifyId
     * @param tags
     * @return
     */
    @PostMapping(value = "/addBlog")
    public Map<String,Object> addBlog(@RequestParam("userId")Integer userId,
                                      @RequestParam("title")String title,
                                      @RequestParam("briefContent")String briefContent,
                                      @RequestParam("blogContent")String blogContent,
                                      @RequestParam("classifyId")Integer classifyId,
                                      @RequestParam("itClassifyId")Integer itClassifyId,
                                      @RequestParam("tags")String tags){
        Blog blog = new Blog();
        blog.setUserId(userId);
        User user = userService.findUser(userId);
        user.setScore(user.getScore()+5);
        blog.setTitle(title);
        blog.setBriefContent(briefContent);
        blog.setBlogContent(blogContent);
        blog.setClassifyId(classifyId);
        blog.setItClassifyId(itClassifyId);
        blog.setLeaveNum(0);
        blog.setViewNum(0);
        blog.setGoodNum(0);
        String[] tags1 = tags.split(";");
        ArrayList<Map<String,Object>> tags2 = new ArrayList<Map<String, Object>>();
        for(int i=0;i<tags1.length;i++){
            Map<String,Object> maps = new HashMap<String, Object>();
            maps.put("text",tags1[i]);
            tags2.add(maps);
        }
        blog.setTags(JSON.toJSONString(tags2));
        blog.setPublishTime(CommonTools.getCurrentTime());
        blog = blogService.addBlog(blog);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("addResult","success");
        response.put("blog",JSON.toJSONString(blog));
        return response;
    }

    /**
     * 更新博客
     * @param blogId
     * @param userId
     * @param title
     * @param blogContent
     * @param classifyId
     * @param itClassifyId
     * @param tags
     * @return
     */
    @PostMapping(value = "/updateBlog")
    public Map<String,Object> updateBlog(@RequestParam("blogId")Integer blogId,
                                         @RequestParam("userId")Integer userId,
                                         @RequestParam("title")String title,
                                         @RequestParam("blogContent")String blogContent,
                                         @RequestParam("classifyId")Integer classifyId,
                                         @RequestParam("itClassifyId")Integer itClassifyId,
                                         @RequestParam("tags")String tags){
        Blog blog = new Blog();
        blog.setBlogId(blogId);
        blog.setUserId(userId);
        blog.setTitle(title);
        blog.setBlogContent(blogContent);
        blog.setClassifyId(classifyId);
        blog.setItClassifyId(itClassifyId);
        blog.setTags(tags);
        Blog blog1 = blogService.getBlog(blogId);
        blog.setPublishTime(blog1.getPublishTime());
        blogService.addBlog(blog);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("updateResult","success");
        return response;
    }

    /**
     * 删除博客
     * @param blogId
     * @return
     */

    @PostMapping(value = "/deleteBlog")
    public Map<String,Object> deleteBlog(@RequestParam("blogId")Integer blogId){
        String result = "";
        blogService.deleteBlog(blogId);
        result = "success";
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("deleteResult",result);
        return response;
    }

}
