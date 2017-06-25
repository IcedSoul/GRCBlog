package com.grc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.grc.entity.Question;
import com.grc.service.QuestionService;
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
public class QuestionController {

    @Autowired
    QuestionService questionService;

    /**
     * 获取所有问题
     * @param userId
     * @return
     */
    @PostMapping(value = "/getAllQuestions")
    public Map<String,Object> getAllQuestions(@RequestParam("userId")Integer userId){
        String result = "";
        List<Question> questionList = questionService.getAllQuestions(userId);
        result = JSONArray.toJSONString(questionList);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("questions",result);
        return response;
    }

    /**
     * 根据Id获取问题
     * @param questionId
     * @return
     */
    @PostMapping(value = "/getQuestion")
    public Map<String,Object> getQuestion(@RequestParam("questionId")Integer questionId){
        String result = "";
        Question question = questionService.getQuestion(questionId);
        result = JSON.toJSONString(question);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("question",result);
        return response;
    }

    /**
     * 添加问题
     * @param userId
     * @param title
     * @param questionContent
     * @param score
     * @return
     */
    @PostMapping(value = "/addQuestion")
    public Map<String,Object> addQuestion(@RequestParam("userId")Integer userId,
                                          @RequestParam("title")String title,
                                          @RequestParam("questionContent")String questionContent,
                                          @RequestParam("score")Integer score){
        Question question = new Question();
        question.setUserId(userId);
        question.setTitle(title);
        question.setQuestionContent(questionContent);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        question.setAnswerNum(0);
        question.setScore(score);
        question.setState(-1);
        question.setAcceptUserId(-1);
        question.setPublishTime(timestamp);
        questionService.addQuestion(question);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("addResult","success");
        return response;
    }

    /**
     * 更新问题
     * @param questionId
     * @param userId
     * @param title
     * @param questionContent
     * @param answerNum
     * @param score
     * @param state
     * @param acceptUserId
     * @return
     */
    @PostMapping(value = "/updateQuestion")
    public Map<String,Object> updateQuestion(@RequestParam("questionId")Integer questionId,
                                             @RequestParam("userId")Integer userId,
                                             @RequestParam("title")String title,
                                             @RequestParam("questionContent")String questionContent,
                                             @RequestParam("answerNum")Integer answerNum,
                                             @RequestParam("score")Integer score,
                                             @RequestParam("state")Integer state,
                                             @RequestParam("acceptUserId")Integer acceptUserId){
        Question question = new Question();
        question.setQuestionId(questionId);
        question.setUserId(userId);
        question.setTitle(title);
        question.setQuestionContent(questionContent);
        question.setAnswerNum(answerNum);
        question.setScore(score);
        question.setState(state);
        question.setAcceptUserId(acceptUserId);
        questionService.updateQuestion(question);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("updateResult","success");
        return response;
    }

    /**
     * 删除问题
     * @param questionId
     * @return
     */
    @PostMapping(value = "/deleteQuestion")
    public Map<String,Object> deleteQuestion(@RequestParam("questionId")Integer questionId){
        String result = "";
        questionService.deleteQuestion(questionId);
        result = "success";
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("deleteResult",result);
        return response;
    }

}
