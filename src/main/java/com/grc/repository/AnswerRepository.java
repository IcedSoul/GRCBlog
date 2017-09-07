package com.grc.repository;

import com.grc.domain.Answer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    public List<Answer> findByQuestionId(Integer questionId);
    public List<Answer> findByAnswerAnswerId(Integer answerAnswerId,Sort sort);
    public List<Answer> findByQuestionIdAndAndAnswerAnswerId(Integer questionId,Integer answerAnswerId);
}
