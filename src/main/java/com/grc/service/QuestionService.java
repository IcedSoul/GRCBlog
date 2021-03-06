package com.grc.service;

import com.grc.domain.Question;
import com.grc.utils.Response;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
public interface QuestionService {
    public List<Question> getAllQuestions(Integer userId);
    public Response getQuestion(Integer questionId);
    public Response addQuestion(Integer userId,String title,String briefContent,String questionContent,Integer score);
    public void updateQuestion(Question question);
    public void deleteQuestion(Integer questionId);
}
