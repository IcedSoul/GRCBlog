package com.grc.service;

import com.grc.entity.Answer;
import com.grc.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
@Service
public class AnswerServiceImplement implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public List<Answer> getQuestionAnswers(Integer questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    @Override
    public Answer getAnswer(Integer answerId) {
        return answerRepository.findOne(answerId);
    }

    @Override
    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void deleteAnswer(Integer answerId) {
        answerRepository.delete(answerId);
    }
}
