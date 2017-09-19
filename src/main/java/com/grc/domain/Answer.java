package com.grc.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by 14437 on 2017/6/20.
 */
@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '答案主键'")
    private Integer answerId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '问题外键'")
    private Integer questionId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '用户外键'")
    private Integer userId;
    @Column(nullable = false, columnDefinition = "varchar(10000) COMMENT '回答内容'")
    private String answerContent;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, columnDefinition = "datetime COMMENT '回复时间'")
    private Timestamp publishTime;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '回答答案主键'")
    private Integer answerAnswerId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '层数'")
    private Integer level;
}
