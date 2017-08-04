package com.grc.domain;

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
    private Timestamp registerTime;
    private String phone;
    private String address;
    private String interest;
    private Timestamp birthday;
    private String remark;
    private String job;
}
