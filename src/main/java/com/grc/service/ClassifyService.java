package com.grc.service;

import com.grc.entity.Classify;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
public interface ClassifyService {
    public void addClassify(Classify classify);
    public void updateClassify(Classify classify);
    public void deleteClassify(Integer classifyId);
    public Classify getClassify(Integer classifyId);
    public List<Classify> getUserClassifys(Integer userId);
}
