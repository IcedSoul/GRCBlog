package com.grc.service;

import com.grc.domain.Answer;
import com.grc.utils.Response;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
public interface AnswerService {
    Response getQuestionAnswers(Integer questionId);
    public Answer getAnswer(Integer answerId);
    Response addAnswer(Integer questionId, Integer userId, String answerContent, Integer answerAnswerId, Integer level);
    public void deleteAnswer(Integer answerId);
}
