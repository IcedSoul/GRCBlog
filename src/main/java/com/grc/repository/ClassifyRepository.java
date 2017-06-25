package com.grc.repository;

import com.grc.entity.Classify;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by 14437 on 2017/6/21.
 */
public interface ClassifyRepository extends JpaRepository<Classify,Integer> {
    public List<Classify> findByUserId(Integer userId);
}
