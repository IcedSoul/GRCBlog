package com.grc.service;

import com.grc.entity.Question;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
public interface QuestionService {
    public List<Question> getAllQuestions(Integer userId);
    public Question getQuestion(Integer questionId);
    public void addQuestion(Question question);
    public void updateQuestion(Question question);
    public void deleteQuestion(Integer questionId);
}
