package com.nuoxin.virtual.rep.api.web.controller.request.customer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Create by tiancun on 2017/9/22
 */
@ApiModel(value = "客户设置")
public class DoctorDynamicFieldRequestBean implements Serializable{
    private static final long serialVersionUID = 4172100860423852688L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "字段名称")
    private String name;


    @ApiModelProperty(value = "字段类型，1是文本，2是下拉框")
    private Integer type;

    @ApiModelProperty(value = "下拉框的值")
    private String value;

    @ApiModelProperty(value = "分类，目前1基本信息，2医生的处方信息，3之前拜访记录，4分析")
    private Integer classification;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}