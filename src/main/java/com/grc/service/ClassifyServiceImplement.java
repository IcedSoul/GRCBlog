package com.grc.service;

import com.grc.entity.Classify;
import com.grc.repository.ClassifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
@Service
public class ClassifyServiceImplement implements ClassifyService {

    @Autowired
    ClassifyRepository classifyRepository;

    @Override
    public void addClassify(Classify classify) {
        classifyRepository.save(classify);
    }

    @Override
    public void updateClassify(Classify classify) {
        classifyRepository.save(classify);
    }

    @Override
    public void deleteClassify(Integer classifyId) {
        classifyRepository.delete(classifyId);
    }

    @Override
    public Classify getClassify(Integer classifyId) {
        return classifyRepository.findOne(classifyId);
    }

    @Override
    public List<Classify> getUserClassifys(Integer userId) {
        return classifyRepository.findByUserId(userId);
    }
}
