package com.grc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.grc.entity.LeaveWord;
import com.grc.service.LeaveWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14437 on 2017/6/25.
 */
@RestController
@EnableAutoConfiguration
public class LeaveWordController {
    @Autowired
    LeaveWordService leaveWordService;

    /**
     * 获取博客的所有留言
     * @param blogId
     * @return
     */
    @PostMapping(value = "/getBlogLeaveWords")
    public Map<String,Object> getBlogLeaveWords(@RequestParam("blogId")Integer blogId){
        String result = "";
        List<LeaveWord> leaveWordList = leaveWordService.getBlogLeaveWords(blogId);
        result = JSONArray.toJSONString(leaveWordList);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("leaveWords",result);
        return response;
    }

    /**
     * 根据留言Id获取留言
     * @param wordId
     * @return
     */
    @PostMapping(value = "/getLeaveWord")
    public Map<String,Object> getLeaveWord(@RequestParam("wordId")Integer wordId){
        String result = "";
        LeaveWord leaveWord = leaveWordService.getLeaveWord(wordId);
        result = JSON.toJSONString(leaveWord);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("leaveWord",result);
        return response;
    }

    /**
     * 添加留言
     * @param userId
     * @param blogId
     * @param leaveContent
     * @param answerId
     * @return
     */
    @PostMapping(value = "/addLeaveWord")
    public Map<String,Object> addLeaveWord(@RequestParam("userId")Integer userId,
                                      @RequestParam("blogId")Integer blogId,
                                      @RequestParam("leaveContent")String leaveContent,
                                      @RequestParam("answerId")Integer answerId){
        LeaveWord leaveWord = new LeaveWord();
        leaveWord.setAnswerId(answerId);
        leaveWord.setLeaveContent(leaveContent);
        leaveWord.setUserId(userId);
        leaveWord.setBlogId(blogId);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        leaveWord.setLeaveTime(timestamp);
        leaveWordService.addLeaveWord(leaveWord);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("addResult","success");
        return response;
    }

    /**
     * 删除留言
     * @param wordId
     * @return
     */
    @PostMapping(value = "/deleteLeaveWord")
    public Map<String,Object> deleteLeaveWord(@RequestParam("wordId")Integer wordId){
        String result = "";
        leaveWordService.deleteLeaveWord(wordId);
        result = "success";
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("deleteResult",result);
        return response;
    }
}
