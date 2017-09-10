package com.grc.repository;

import com.grc.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    @Query("select q from Question q where title like :keyWord or questionContent like :keyWord")
    public List<Question> findByTitleLikeOrQuestionContentLike(@Param("keyWord")String keyWord);
}
