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
public class Question {
    @Id
    @GeneratedValue
    private Integer questionId;
    private Integer userId;
    private String title;
    private String questionContent;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp publishTime;
    private Integer answerNum;
    private Integer score;
    private Integer state;
    private Integer acceptUserId;
    private String briefContent;
}
