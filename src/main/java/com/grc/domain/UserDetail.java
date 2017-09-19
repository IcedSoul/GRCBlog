package com.grc.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by 14437 on 2017/6/20.
 */
@Entity
@Data
public class UserDetail {
    @Id
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '用户主键'")
    private Integer userId;
    @Column(nullable = true, columnDefinition = "varchar(40) COMMENT '性别' ")
    private String sex;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, columnDefinition = "datetime COMMENT '注册时间' ")
    private Timestamp registerTime;
    @Column(nullable = true, columnDefinition = "varchar(40) COMMENT '手机号码' ")
    private String phone;
    @Column(nullable = true, columnDefinition = "varchar(400) COMMENT '地址' ")
    private String address;
    @Column(nullable = true, columnDefinition = "varchar(400) COMMENT '爱好'")
    private String interest;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = true, columnDefinition = "datetime COMMENT '生日' ")
    private Timestamp birthday;
    @Column(nullable = true, columnDefinition = "varchar(2000) COMMENT '简介' ")
    private String remark;
    @Column(nullable = true, columnDefinition = "varchar(400) COMMENT '工作' ")
    private String job;
}
