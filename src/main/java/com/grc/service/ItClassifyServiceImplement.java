package com.grc.service;

import com.grc.entity.ItClassify;
import com.grc.repository.ItClassifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
@Service
public class ItClassifyServiceImplement implements  ItClassifyService {

    @Autowired
    ItClassifyRepository itClassifyRepository;

    @Override
    public List<ItClassify> getAllItClassifys(Integer userId) {
        return itClassifyRepository.findAll();
    }

    @Override
    public ItClassify getItClassify(Integer itClassifyId) {
        return itClassifyRepository.findOne(itClassifyId);
    }

    @Override
    public void addItClassify(ItClassify itClassify) {
        itClassifyRepository.save(itClassify);
    }

    @Override
    public void deleteItClassify(Integer itClassifyId) {
        itClassifyRepository.delete(itClassifyId);
    }

    @Override
    public void updateItClassify(ItClassify itClassify) {
        itClassifyRepository.save(itClassify);
    }
}
