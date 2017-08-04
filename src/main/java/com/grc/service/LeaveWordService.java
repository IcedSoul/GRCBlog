package com.grc.service;

import com.grc.domain.LeaveWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 14437 on 2017/6/23.
 */
public interface LeaveWordService {
    public ArrayList getBlogLeaveWords(Integer blogId);
    public LeaveWord getLeaveWord(Integer wordId);
    public LeaveWord addLeaveWord(LeaveWord leaveWord);
    public void deleteLeaveWord(Integer wordId);
}
