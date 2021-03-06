package com.grc.repository;

import com.grc.domain.LeaveWord;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface LeaveWordRepository extends JpaRepository<LeaveWord,Integer> {
    public List<LeaveWord> findByBlogId(Integer blogId);
    public List<LeaveWord> findByAnswerId(Integer answerId,Sort sort);
    public List<LeaveWord> findByBlogIdAndAnswerId(Integer blogId,Integer answerId);
}
