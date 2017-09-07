package com.grc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.grc.domain.Answer;
import com.grc.repository.AnswerRepository;
import com.grc.repository.UserRepository;
import com.grc.utils.CommonTools;
import com.grc.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14437 on 2017/6/23.
 */
@Service
public class AnswerServiceImplement implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Response getQuestionAnswers(Integer questionId) {
        try {
            List<Answer> answers = answerRepository.findByQuestionIdAndAndAnswerAnswerId(questionId,-1);
            String answer = JSONArray.toJSONString(getAnswer(answers), SerializerFeature.UseSingleQuotes);
            return new Response("0","获取答案成功",answer);
        }catch (Exception e){
            return new Response("-1","服务器异常","");
        }


    }

    @Override
    public Answer getAnswer(Integer answerId) {
        return answerRepository.findOne(answerId);
    }

    @Override
    public Response addAnswer(Integer questionId, Integer userId, String answerContent, Integer answerAnswerId, Integer level) {
        Answer answer = new Answer();
        answer.setQuestionId(questionId);
        answer.setUserId(userId);
        answer.setAnswerContent(answerContent);
        answer.setAnswerAnswerId(answerAnswerId);
        answer.setLevel(level);
        answer.setPublishTime(CommonTools.getCurrentTime());
        answer = answerRepository.save(answer);
        return new Response("0","添加答案成功", JSON.toJSONString(answer));
    }


    @Override
    public void deleteAnswer(Integer answerId) {
        answerRepository.delete(answerId);
    }

    private ArrayList getAnswers(Integer answerAnswerId){
        Sort sort = new Sort(Sort.Direction.DESC,"publishTime");
        List<Answer> answers = answerRepository.findByAnswerAnswerId(answerAnswerId,sort);
        if(answers == null || answers.size() ==0) return null;
        return getAnswer(answers);
    }

    private ArrayList getAnswer(List<Answer> answers){
        ArrayList arrayList = new ArrayList();
        for(int i =0 ; i<answers.size(); i++){
            Answer answer = answers.get(i);
            Map<String,Object> answer1 = new HashMap<String,Object>();
            answer1.put("answerId",answer.getAnswerId());
            answer1.put("userName",userRepository.findOne(answer.getUserId()).getUserName());
            answer1.put("answerContent",answer.getAnswerContent());
            answer1.put("level",answer.getLevel());
            answer1.put("publishTime",CommonTools.dateFormat.format(answer.getPublishTime()));
            answer1.put("childWord",getAnswers(answer.getAnswerId()));
            arrayList.add(answer1);
        }
        return arrayList;
    }
}
