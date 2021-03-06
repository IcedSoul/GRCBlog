package com.grc.service;

import com.grc.domain.User;
import com.grc.domain.UserDetail;
import com.grc.utils.Response;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 14437 on 2017/6/20.
 */

public interface UserService {
    void insertUser(User user, UserDetail userDetail);
    User findUser(int userId);
    User findByUserName(String userName);
    UserDetail findUserDetail(int userId);
    Response search(Integer userId,String keyWord);
    Response uploadIMG(MultipartFile imgUpload, Integer userId);
}
