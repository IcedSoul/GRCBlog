package com.grc.service;

import com.grc.domain.User;
import com.grc.domain.UserDetail;

/**
 * Created by 14437 on 2017/6/20.
 */

public interface UserService {
    void insertUser(User user, UserDetail userDetail);
    User findUser(int userId);
    User findByUserName(String userName);
    UserDetail findUserDetail(int userId);
}
