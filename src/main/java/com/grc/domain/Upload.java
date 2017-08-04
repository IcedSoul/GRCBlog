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
public class Upload {
    @Id
    @GeneratedValue
    private Integer fileId;
    private Integer userId;
    private String filePath;
    private String name;
    private String remark;
    private Integer itClassifyId;
    private String keyword;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp upTime;
    private Integer downNum;
    private Integer score;
}
