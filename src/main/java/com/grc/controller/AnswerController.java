package com.grc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.grc.domain.Answer;
import com.grc.service.AnswerService;
import com.grc.utils.Response;
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
public class AnswerController {

    @Autowired
    AnswerService answerService;

    /**
     * 获取一个问题的所有答案
     * @param questionId
     * @return
     */
    @PostMapping(value = "/getQuestionAnswers")
    public Response getQuestionAnswers(@RequestParam("questionId")Integer questionId){
        return answerService.getQuestionAnswers(questionId);
    }

    /**
     * 根据答案Id获取答案
     * @param answerId
     * @return
     */
    @PostMapping(value = "/getAnswer")
    public Map<String,Object> getAnswer(@RequestParam("answerId")Integer answerId){
        String result = "";
        Answer answer = answerService.getAnswer(answerId);
        result = JSON.toJSONString(answer);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("answer",result);
        return response;
    }

    /**
     * 添加一个回答
     * @param questionId
     * @param userId
     * @param answerContent
     * @param answerAnswerId
     * @return
     */

    @PostMapping(value = "/addAnswer")
    public Response addAnswer(@RequestParam("questionId")Integer questionId,
                              @RequestParam("userId")Integer userId,
                              @RequestParam("answerContent")String answerContent,
                              @RequestParam("answerAnswerId")Integer answerAnswerId,
                              @RequestParam("level")Integer level){
        return answerService.addAnswer(questionId,userId,answerContent,answerAnswerId,level);
    }

    /**
     * 删除一个回答
     * @param answerId
     * @return
     */
    @PostMapping(value = "/deleteAnswer")
    public Map<String,Object> deleteAnswer(@RequestParam("answerId")Integer answerId){
        String result = "";
        answerService.deleteAnswer(answerId);
        result = "success";
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("deleteResult",result);
        return response;
    }
}
