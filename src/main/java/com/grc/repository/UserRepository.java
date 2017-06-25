package com.grc.repository;

import com.grc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 14437 on 2017/6/20.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    //通过用户名来查询
    public User findByUserName(String userName);
}
