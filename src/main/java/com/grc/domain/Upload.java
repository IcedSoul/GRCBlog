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
public class Upload {
    @Id
    @GeneratedValue
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '文件主键'")
    private Integer fileId;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '用户外键' ")
    private Integer userId;
    @Column(nullable = false, columnDefinition = "varchar(2000) COMMENT '文件路径' ")
    private String filePath;
    @Column(nullable = false, columnDefinition = "varchar(2000) COMMENT '资源名称' ")
    private String name;
    @Column(nullable = false, columnDefinition = "varchar(5000) COMMENT '标签' ")
    private String remark;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '用户整体分类' ")
    private Integer itClassifyId;
    @Column(nullable = false, columnDefinition = "varchar(5000) COMMENT '关键词' ")
    private String keyWord;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false, columnDefinition = "datetime COMMENT '上传时间' ")
    private Timestamp upTime;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '下载次数' ")
    private Integer downNum;
    @Column(nullable = false, columnDefinition = "Int(11) COMMENT '所需积分' ")
    private Integer score;
}
