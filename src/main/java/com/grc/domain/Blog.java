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
public class Blog {
    @Id
    @GeneratedValue
    private Integer blogId;
    private Integer userId;
    private String title;
    private String briefContent;
    private String blogContent;
    private Integer classifyId;
    private Integer itClassifyId;
    private Integer viewNum;
    private Integer leaveNum;
    private Integer goodNum;
    private String tags;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp publishTime;
}
