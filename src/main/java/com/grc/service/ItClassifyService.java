package com.grc.service;

import com.grc.entity.ItClassify;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
public interface ItClassifyService {
    public List<ItClassify> getAllItClassifys(Integer userId);
    public ItClassify getItClassify(Integer itClassifyId);
    public void addItClassify(ItClassify itClassify);
    public void deleteItClassify(Integer itClassifyId);
    public  void updateItClassify(ItClassify itClassify);
}
