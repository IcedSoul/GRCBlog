package com.grc.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

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
    private Integer userId;
    private String sex;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp registerTime;
    private String phone;
    private String address;
    private String interest;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp birthday;
    private String remark;
    private String job;
}
