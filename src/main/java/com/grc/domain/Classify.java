package com.grc.domain;

import lombok.Data;

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
    private Integer classifyId;
    private Integer userId;
    private String classifyName;
}
