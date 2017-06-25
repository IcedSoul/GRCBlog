package com.grc.service;

import com.grc.entity.LeaveWord;
import com.grc.repository.LeaveWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
@Service
public class LeaveWordServiceImplemrnt implements LeaveWordService {

    @Autowired
    LeaveWordRepository leaveWordRepository;

    @Override
    public List<LeaveWord> getBlogLeaveWords(Integer blogId) {
        return leaveWordRepository.findByBlogId(blogId);
    }

    @Override
    public LeaveWord getLeaveWord(Integer wordId) {
        return leaveWordRepository.findOne(wordId);
    }

    @Override
    public void addLeaveWord(LeaveWord leaveWord) {
        leaveWordRepository.save(leaveWord);
    }

    @Override
    public void deleteLeaveWord(Integer wordId) {
        leaveWordRepository.delete(wordId);
    }
}
