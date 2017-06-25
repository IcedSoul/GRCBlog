package com.grc.repository;

import com.grc.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 14437 on 2017/6/20.
 */
public interface UserDetailRepository extends JpaRepository<UserDetail,Integer> {
}
