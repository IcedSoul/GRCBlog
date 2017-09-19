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
public class LeaveWord {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '留言主键'")
    private Integer wordId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '博客外键'")
    private Integer blogId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '用户外键' ")
    private Integer userId;
    @Column(nullable = false, columnDefinition = "varchar(5000) COMMENT '留言内容' ")
    private String leaveContent;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '回答的主键' ")
    private Integer answerId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '层数' ")
    private Integer level;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, columnDefinition = "datetime COMMENT '回复时间' ")
    private Timestamp leaveTime;
}
