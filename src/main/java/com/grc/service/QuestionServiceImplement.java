package com.grc.service;

import com.grc.entity.Question;
import com.grc.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Question getQuestion(Integer questionId) {
        return questionRepository.findOne(questionId);
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
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
