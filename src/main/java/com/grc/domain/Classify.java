package com.grc.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 14437 on 2017/6/20.
 */
@Entity
@Data
public class Classify {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '分类主键'")
    private Integer classifyId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '用户外键' ")
    private Integer userId;
    @Column(nullable = false, columnDefinition = "varchar(500) COMMENT '分类名'")
    private String classifyName;
}
