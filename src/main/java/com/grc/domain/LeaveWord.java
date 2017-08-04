package com.grc.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by 14437 on 2017/6/20.
 */
@Entity
@Data
public class LeaveWord {
    @Id
    @GeneratedValue
    private Integer wordId;
    private Integer blogId;
    private Integer userId;
    private String leaveContent;
    private Integer answerId;
    private Integer level;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp leaveTime;
}
