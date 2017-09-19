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
public class ItClassify {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '整体分类主键'")
    private Integer itClassifyId;
    @Column(nullable = false, columnDefinition = "varchar(500) COMMENT '整体分类名称'")
    private String itClassifyName;
}
