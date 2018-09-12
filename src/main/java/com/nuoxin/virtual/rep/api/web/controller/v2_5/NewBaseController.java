package com.nuoxin.virtual.rep.api.web.controller.v2_5;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.nuoxin.virtual.rep.api.common.bean.DefaultResponseBean;
import com.nuoxin.virtual.rep.api.common.enums.ErrorEnum;
import com.nuoxin.virtual.rep.api.entity.DrugUser;
import com.nuoxin.virtual.rep.api.service.SecurityService;

/**
 * 新的 BaseController
 * @author xiekaiyu
 */
public class NewBaseController {
	
	@Resource
	private SecurityService sercurityService;
	
	/**
	 * 根据 request 从会话变量中获取 DrugUser 信息 
	 * @param request
	 * @return 成功返回 DrugUser 对象,否则返回 null
	 */
	protected DrugUser getDrugUser(HttpServletRequest request) {
		return sercurityService.getDrugUser(request);
	}
	
	/**
	 * 登录错误信息
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected DefaultResponseBean getLoginErrorResponse() {
		DefaultResponseBean responseBean = new DefaultResponseBean<>();
		ErrorEnum loginError = ErrorEnum.LOGIN_NO;
		responseBean.setCode(loginError.getStatus());
		responseBean.setMessage(loginError.getMessage());
		responseBean.setDescription(loginError.getMessage());
		return responseBean;
	}
	
	/**
	 * 返回带有错误信息
	 * @param msg
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected DefaultResponseBean getParamsErrorResponse(String msg) {
		DefaultResponseBean responseBean = new DefaultResponseBean<>();
		ErrorEnum loginError = ErrorEnum.SYSTEM_REQUEST_PARAM_ERROR;
		responseBean.setCode(loginError.getStatus());
		responseBean.setMessage(msg);
		responseBean.setDescription(msg);
		return responseBean;
	}
	
}