package com.nuoxin.virtual.rep.api.web.controller.request.v2_5.callinfo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.nuoxin.virtual.rep.api.web.controller.request.v2_5.questionnaire.VirtualQuestionRequestBean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(value = "保存电话拜访接通后的信息")
@EqualsAndHashCode(callSuper=false)
@Data
public class SaveCallInfoRequest  extends BaseCallInfoRequest{
	@NotNull(message="isHasDrug is null 1.有,0.无")
	@ApiModelProperty(value = "是否有药")
	private Integer isHasDrug;
	@NotNull(message="isTarget is null")
	@ApiModelProperty(value = "是否是目标客户 1.是,0.非")
	private Integer isTarget;
	@NotNull(message="isHasAe is null")
	@ApiModelProperty(value = "是否有 AE 1.是,0.非")
	private Integer isHasAe;
	@ApiModelProperty(value = "医生态度 0-5")
	private Integer attitude;
	@ApiModelProperty(value = "拜访结果,以字符串数组形式传入如[\"a\",\"b\"]")
	private List<String> visitResult;
	
	///////////////////////////////////////////////////////
	
	@NotNull(message="virtualQuestionaireId is null")
	@ApiModelProperty(value = "问卷ID")
	private Integer virtualQuestionaireId;
	@ApiModelProperty(value = "作答结果")
	List<VirtualQuestionRequestBean> questions = new ArrayList<>();
}