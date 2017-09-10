package com.grc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.grc.domain.*;
import com.grc.repository.*;
import com.grc.utils.Response;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14437 on 2017/6/20.
 */
@Service
@Log
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UploadRepository uploadRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Value("${web.upload-path}")
    private String path;

    @Override
    @Transactional
    public void insertUser(User user, UserDetail userDetail) {
        //此处将user表与userDetail表的插入作为一个事务来处理
        //同时为了保证user表与userDetail的一一映射，先插入user，然后获取到userId赋值给userDetail以确保正常
        userRepository.save(user);
        User user1 = userRepository.findByUserName(user.getUserName());
        //System.out.println("-----"+userDetail.getPhone());
        userDetail.setUserId(user1.getUserId());
        userDetailRepository.save(userDetail);
    }

    @Override
    public User findUser(int userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserDetail findUserDetail(int userId) {
        return userDetailRepository.findOne(userId);
    }

    @Override
    public Response search(Integer userId, String keyWord) {
        Map<String,Object> result = new HashMap<String, Object>();
        keyWord = keyWord.replaceAll("%20"," ");
        String[] keyWords = keyWord.split(" ");
        log.info("----------------start searching----------------------");
        List<Blog> blogs = new ArrayList<Blog>();
        List<Question> questions = new ArrayList<Question>();
        List<Upload> uploads = new ArrayList<Upload>();
        for(int i=0;i<keyWords.length;i++) {
            keyWords[i] = "%"+keyWords[i]+"%";
            List<Blog> blog1 = blogRepository.findByTitleLikeOrTagsLikeOrBlogContentLike(keyWords[i]);
            List<Question> questions1 = questionRepository.findByTitleLikeOrQuestionContentLike(keyWords[i]);
            List<Upload> upload1 = uploadRepository.findByFilePathLikeOrNameLikeOrKeywordLikeOrRemarkLike(keyWords[i]);
            blogs.removeAll(blog1);
            blogs.addAll(blog1);
            questions.removeAll(questions1);
            questions.addAll(questions1);
            uploads.removeAll(upload1);
            uploads.addAll(upload1);
        }
        result.put("blog", JSONArray.toJSONString(blogs));
        result.put("question", JSONArray.toJSONString(questions));
        result.put("upload", JSONArray.toJSONString(uploads));
        return new Response("0","搜索成功", JSON.toJSONString(result));
    }

    @Override
    public Response uploadIMG(MultipartFile fileUpload, Integer userId) {
        try{
            if(fileUpload != null && !fileUpload.isEmpty()) {
                String fileName = fileUpload.getOriginalFilename();
                File fileFolder = new File(path+"img/");
                if(!fileFolder.exists()){
                    fileFolder.mkdirs();
                }
                File file = new File(fileFolder,fileName);
                fileUpload.transferTo(file);
                return new Response("0","头像上传成功",file.getAbsolutePath());
            }
        }catch(Exception e){
            return new Response("-1","头像上传失败","");
        }
        return new Response("-1","头像上传失败","");
    }
}
