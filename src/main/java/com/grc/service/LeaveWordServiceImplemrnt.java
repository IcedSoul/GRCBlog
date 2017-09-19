package com.grc.service;

import com.grc.domain.LeaveWord;
import com.grc.repository.LeaveWordRepository;
import com.grc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14437 on 2017/6/23.
 */
@Service
public class LeaveWordServiceImplemrnt implements LeaveWordService {

    @Autowired
    LeaveWordRepository leaveWordRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public ArrayList getBlogLeaveWords(Integer blogId) {
        List<LeaveWord> leaveWords = leaveWordRepository.findByBlogIdAndAnswerId(blogId,-1);
        return getWord(leaveWords);
    }

    @Override
    public LeaveWord getLeaveWord(Integer wordId) {
        return leaveWordRepository.findOne(wordId);
    }

    @Override
    public LeaveWord addLeaveWord(LeaveWord leaveWord) {
        return leaveWordRepository.save(leaveWord);
    }

    @Override
    public void deleteLeaveWord(Integer wordId) {
        leaveWordRepository.delete(wordId);
    }

    private ArrayList getLeaveWords(Integer answerId){
        Sort sort = new Sort(Sort.Direction.DESC,"leaveTime");
        List<LeaveWord> leaveWords = leaveWordRepository.findByAnswerId(answerId,sort);
        if(leaveWords == null || leaveWords.size() ==0) return null;
        return getWord(leaveWords);
    }

    private ArrayList getWord(List<LeaveWord> leaveWords){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayList arrayList = new ArrayList();
        for(int i =0 ; i<leaveWords.size(); i++){
            LeaveWord leaveWord = leaveWords.get(i);
            Map<String,Object> word = new HashMap<String,Object>();
            word.put("wordId",leaveWord.getWordId());
            word.put("userName",userRepository.findOne(leaveWord.getUserId()).getUserName());
            word.put("img",userRepository.findOne(leaveWord.getUserId()).getImg());
            word.put("level",leaveWord.getLevel());
            word.put("leaveContent",leaveWord.getLeaveContent());
            word.put("leaveTime",df.format(leaveWord.getLeaveTime()));
            word.put("childWord",getLeaveWords(leaveWord.getWordId()));
            arrayList.add(word);
        }
        return arrayList;
    }
}
