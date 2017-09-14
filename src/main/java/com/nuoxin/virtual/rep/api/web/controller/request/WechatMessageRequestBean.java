package com.nuoxin.virtual.rep.api.web.controller.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "微信消息excel接收类")
public class WechatMessageRequestBean implements Serializable{
    private static final long serialVersionUID = 338219961625669631L;

    @ApiModelProperty(value = "微信消息id")
    private String id;

    @ApiModelProperty(value = "用户类型,1是销售代表，2是医生")
    private Integer userType;

    @ApiModelProperty(value = "用户名称或者备注")
    private String nickname;


    @ApiModelProperty(value = "微信号")
    private String wechatNumber;

    @ApiModelProperty(value = "手机号")
    private String telephone;

    @ApiModelProperty(value = "消息状态，发送或者接收")
    private String messageStatus;

    @ApiModelProperty(value = "微信聊天消息")
    private String messsge;

    @ApiModelProperty(value = "聊天消息类型")
    private String messageType;

    @ApiModelProperty(value = "微信聊天时间")
    private String wechatTime;


    @ApiModelProperty(value = "创建时间")
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getMesssge() {
        return messsge;
    }

    public void setMesssge(String messsge) {
        this.messsge = messsge;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getWechatTime() {
        return wechatTime;
    }

    public void setWechatTime(String wechatTime) {
        this.wechatTime = wechatTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}