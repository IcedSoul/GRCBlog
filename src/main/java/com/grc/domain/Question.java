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
public class Question {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '问题主键'")
    private Integer questionId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '用户外键'")
    private Integer userId;
    @Column(nullable = false, columnDefinition = "varchar(200) COMMENT '标题' ")
    private String title;
    @Column(nullable = false, columnDefinition = "text COMMENT '简要问题内容' ")
    private String briefContent;
    @Column(nullable = false, columnDefinition = "text COMMENT '问题内容' ")
    private String questionContent;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, columnDefinition = "datetime COMMENT '发表时间' ")
    private Timestamp publishTime;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '回答数' ")
    private Integer answerNum;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '悬赏积分' ")
    private Integer score;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '问题状态' ")
    private Integer state;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '用户外键' ")
    private Integer acceptUserId;

}
