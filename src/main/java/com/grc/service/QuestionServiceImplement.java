package com.grc.service;

import com.alibaba.fastjson.JSON;
import com.grc.domain.Question;
import com.grc.repository.QuestionRepository;
import com.grc.utils.CommonTools;
import com.grc.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14437 on 2017/6/23.
 */
@Service
public class QuestionServiceImplement implements QuestionService{

    @Autowired
    QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestions(Integer userId) {
        return questionRepository.findAll();
    }

    @Override
    public Response getQuestion(Integer questionId) {
        Question question = questionRepository.findOne(questionId);
        if(question!=null)
            return new Response("0","获取成功",JSON.toJSONString(question));
        return new Response("-1","获取失败","");
    }

    @Override
    public Response addQuestion(Integer userId,String title,String questionContent,Integer score) {
        try {
            Question question = new Question();
            question.setUserId(userId);
            question.setTitle(title);
            question.setQuestionContent(questionContent);
            question.setAnswerNum(0);
            question.setScore(score);
            question.setState(-1);
            question.setAcceptUserId(-1);
            question.setPublishTime(CommonTools.getCurrentTime());
            question = questionRepository.save(question);
            return new Response("0", "添加成功", JSON.toJSONString(question));
        }catch (Exception e){
            return new Response("-1", "添加失败", "");
        }
    }

    @Override
    public void updateQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Integer questionId) {
        questionRepository.delete(questionId);
    }
}
