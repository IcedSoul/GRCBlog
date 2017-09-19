package com.grc.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 14437 on 2017/6/20.
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '用户主键'")
    private Integer userId;
    @Column(nullable = false, columnDefinition = "varchar(40) COMMENT '用户名' ")
    private String userName;
    @Column(nullable = false, columnDefinition = "varchar(40) COMMENT '用户密码' ")
    private String userPassword;
    @Column(nullable = true, columnDefinition = "varchar(100) COMMENT '邮箱' ")
    private String email;
    @Column(nullable = true, columnDefinition = "varchar(400) COMMENT '头像地址' ")
    private String img;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '积分数' ")
    private Integer score;
}
