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
public class Blog {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '博客主键'")
    private Integer blogId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '用户ID'")
    private Integer userId;
    @Column(nullable = false, columnDefinition = "varchar(200) COMMENT '标题'")
    private String title;
    @Column(nullable = false, columnDefinition = "text COMMENT '博客简要内容'")
    private String briefContent;
    @Column(nullable = false, columnDefinition = "text COMMENT '博客内容' ")
    private String blogContent;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '分类'")
    private Integer classifyId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '整体分类'")
    private Integer itClassifyId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '阅读次数'")
    private Integer viewNum;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '评论数量'")
    private Integer leaveNum;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '点赞数'")
    private Integer goodNum;
    @Column(nullable = false, columnDefinition = "varchar(5000) COMMENT '标签'")
    private String tags;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, columnDefinition = "datetime COMMENT '发表时间'")
    private Timestamp publishTime;
}
