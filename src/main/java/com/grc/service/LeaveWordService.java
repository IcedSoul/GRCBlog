package com.grc.service;

import com.grc.entity.LeaveWord;

import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
public interface LeaveWordService {
    public List<LeaveWord> getBlogLeaveWords(Integer blogId);
    public LeaveWord getLeaveWord(Integer wordId);
    public void addLeaveWord(LeaveWord leaveWord);
    public void deleteLeaveWord(Integer wordId);
}
