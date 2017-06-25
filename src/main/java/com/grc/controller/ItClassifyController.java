package com.grc.controller;

import com.alibaba.fastjson.JSONArray;
import com.grc.entity.ItClassify;
import com.grc.service.ItClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14437 on 2017/6/25.
 */
@RestController
@EnableAutoConfiguration
public class ItClassifyController {
    @Autowired
    ItClassifyService itClassifyService;

    /**
     * 获取所有整体分类
     * @param userId
     * @return
     */

    @PostMapping(value = "/getAllItClassifys")
    public Map<String,Object> getUserClassifys(@RequestParam("userId")Integer userId){
        String result = "";
        List<ItClassify> itClassifyList = itClassifyService.getAllItClassifys(userId);
        result = JSONArray.toJSONString(itClassifyList);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("itClassifys",result);
        return response;
    }

    /**
     * 添加整体分类
     * @param itClassifyName
     * @return
     */

    @PostMapping(value = "/addItClassify")
    public Map<String,Object> addClassify(@RequestParam("itClassifyName")String itClassifyName){
        String result = "";
        ItClassify itClassify = new ItClassify();
        itClassify.setItClassifyName(itClassifyName);
        result = "success";
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("addResult",result);
        return response;
    }

    /**
     *更新整体分类
     * @param itClassifyId
     * @param itClassifyName
     * @return
     */
    @PostMapping(value = "/updateItClassify")
    public Map<String,Object> updateItClassify(@RequestParam("itClassifyId")Integer itClassifyId,
                                             @RequestParam("itClassifyName")String itClassifyName){
        String result = "";
        ItClassify itClassify = new ItClassify();
        itClassify.setItClassifyId(itClassifyId);
        itClassify.setItClassifyName(itClassifyName);
        result = "success";
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("addResult",result);
        return response;
    }

    /**
     * 删除整体分类
     * @param itClassifyId
     * @return
     */
    @PostMapping(value = "/deleteItClassify")
    public Map<String,Object> deleteItClassify(@RequestParam("itClassifyId")Integer itClassifyId){
        String result = "";
        itClassifyService.deleteItClassify(itClassifyId);
        result = "success";
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("deleteResult",result);
        return response;
    }
}
