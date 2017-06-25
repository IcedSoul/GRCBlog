package com.grc.controller;

import com.alibaba.fastjson.JSONArray;
import com.grc.entity.Classify;
import com.grc.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14437 on 2017/6/23.
 */
@RestController
@EnableAutoConfiguration
public class ClassifyController {

    @Autowired
    ClassifyService classifyService;

    /**
     * 获取用户的所有分类
     * @param userId
     * @return
     */

    @PostMapping(value = "/getUserClassifys")
    public Map<String,Object> getUserClassifys(@RequestParam("userId")Integer userId){
        String result = "";
        List<Classify> classifyList = classifyService.getUserClassifys(userId);
        result = JSONArray.toJSONString(classifyList);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("classifys",result);
        return response;
    }

    /**
     * 添加分类
     * @param userId
     * @param classifyName
     * @return
     */

    @PostMapping(value = "/addClassify")
    public Map<String,Object> addClassify(@RequestParam("userId")Integer userId,
                                          @RequestParam("classifyName")String classifyName){
        String result = "";
        Classify classify = new Classify();
        classify.setUserId(userId);
        classify.setClassifyName(classifyName);
        classifyService.addClassify(classify);
        result = "success";
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("addResult",result);
        return response;
    }

    /**
     * 更新用户分类
     * @param classifyId
     * @param userId
     * @param classifyName
     * @return
     */
    @PostMapping(value = "/updateClassify")
    public Map<String,Object> updateClassify(@RequestParam("classifyId")Integer classifyId,
                                             @RequestParam("userId")Integer userId,
                                             @RequestParam("classifyName")String classifyName){
        String result = "";
        Classify classify = new Classify();
        classify.setClassifyId(classifyId);
        classify.setUserId(userId);
        classify.setClassifyName(classifyName);
        classifyService.addClassify(classify);
        result = "success";
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("addResult",result);
        return response;
    }

    /**
     * 删除分类
     * @param classifyId
     * @return
     */
    @PostMapping(value = "/deleteClassify")
    public Map<String,Object> deleteClassify(@RequestParam("classifyId")Integer classifyId){
        String result = "";
        classifyService.deleteClassify(classifyId);
        result = "success";
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("deleteResult",result);
        return response;
    }
}
