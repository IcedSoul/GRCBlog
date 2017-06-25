package com.grc.repository;

import com.grc.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
