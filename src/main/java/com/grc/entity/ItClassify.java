package com.grc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 14437 on 2017/6/20.
 */
@Entity
public class ItClassify {
    @Id
    @GeneratedValue
    private Integer itClassifyId;
    private String itClassifyName;

    public ItClassify(){}

    public Integer getItClassifyId() {
        return itClassifyId;
    }

    public void setItClassifyId(Integer itClassifyId) {
        this.itClassifyId = itClassifyId;
    }

    public String getItClassifyName() {
        return itClassifyName;
    }

    public void setItClassifyName(String itClassifyName) {
        this.itClassifyName = itClassifyName;
    }
}
