package com.grc.repository;

import com.grc.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    public List<Answer> findByQuestionId(Integer questionId);
}
