package com.grc.service;

import com.grc.entity.Answer;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
public interface AnswerService {
    public List<Answer> getQuestionAnswers(Integer questionId);
    public Answer getAnswer(Integer answerId);
    public void addAnswer(Answer answer);
    public void deleteAnswer(Integer answerId);
}
