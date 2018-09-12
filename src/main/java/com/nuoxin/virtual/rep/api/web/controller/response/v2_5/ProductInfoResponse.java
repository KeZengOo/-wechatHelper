package com.nuoxin.virtual.rep.api.web.controller.response.v2_5;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("产品信息")
@Data
public class ProductInfoResponse {
	@ApiModelProperty(value = "产品名")
	private String productName;
	@ApiModelProperty(value = "是否招募")
	private 	Integer isRecruit;
	@ApiModelProperty(value = "医生潜力")
	private Integer doctorPotential;
	@ApiModelProperty(value = "客户医生等级")
	private String doctorLevel;
	@ApiModelProperty(value = "是否有药")
	private Integer isHasDrug;
}