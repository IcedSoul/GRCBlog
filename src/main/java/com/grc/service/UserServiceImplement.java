package com.grc.service;

import com.grc.entity.User;
import com.grc.entity.UserDetail;
import com.grc.repository.UserDetailRepository;
import com.grc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 14437 on 2017/6/20.
 */
@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    @Transactional
    public void insertUser(User user, UserDetail userDetail) {
        //此处将user表与userDetail表的插入作为一个事务来处理
        //同时为了保证user表与userDetail的一一映射，先插入user，然后获取到userId赋值给userDetail以确保正常
        userRepository.save(user);
        User user1 = userRepository.findByUserName(user.getUserName());
        //System.out.println("-----"+userDetail.getPhone());
        userDetail.setUserId(user1.getUserId());
        userDetailRepository.save(userDetail);
    }

    @Override
    public User findUser(int userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserDetail findUserDetail(int userId) {
        return userDetailRepository.findOne(userId);
    }
}
