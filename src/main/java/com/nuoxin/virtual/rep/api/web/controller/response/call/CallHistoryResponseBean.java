package com.nuoxin.virtual.rep.api.web.controller.response.call;

import com.nuoxin.virtual.rep.api.web.controller.request.question.QuestionnaireRequestBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fenggang on 9/12/17.
 */
@ApiModel
public class CallHistoryResponseBean implements Serializable {

    private static final long serialVersionUID = 7700413918193431527L;

    @ApiModelProperty(value = "id")
    private Long doctorId;
    @ApiModelProperty(value = "录音文件地址")
    private String dataUrl;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty(value = "来电类型")
    private Integer type;
    @ApiModelProperty(value = "通话时长（时间戳）")
    private Long times;
    @ApiModelProperty(value = "通话时间（yyyy-MM-dd HH:mm）")
    private String timeStr;
    @ApiModelProperty(value = "是否是当前记录")
    private Boolean current = false;
    @ApiModelProperty(value = "通话时间（时间戳）")
    private Long timeLong;
    @ApiModelProperty(value = "问卷信息")
    private List<QuestionnaireRequestBean> questions;
    @ApiModelProperty(value = "跟进类型")
    private String followUpType;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "状态名称")
    private String statusName;

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }

    public List<QuestionnaireRequestBean> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionnaireRequestBean> questions) {
        this.questions = questions;
    }

    public Long getTimeLong() {
        return timeLong;
    }

    public void setTimeLong(Long timeLong) {
        this.timeLong = timeLong;
    }

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public String getFollowUpType() {
        return followUpType;
    }

    public void setFollowUpType(String followUpType) {
        this.followUpType = followUpType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}