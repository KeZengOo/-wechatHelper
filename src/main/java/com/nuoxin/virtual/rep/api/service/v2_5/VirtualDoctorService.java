package com.nuoxin.virtual.rep.api.service.v2_5;

import com.nuoxin.virtual.rep.api.entity.DrugUser;
import com.nuoxin.virtual.rep.api.web.controller.request.v2_5.doctor.SaveVirtualDoctorRequest;

public interface VirtualDoctorService {

	/**
	 * 保存单个客户医生信息,开启事务<br>
	 * 涉及 hospital,doctor,drug_user_doctor,drug_user_doctor_quate 表
	 * @param request
	 * @return 成功返回true 否则返回 false
	 */
	boolean saveVirtualDoctor(SaveVirtualDoctorRequest request, DrugUser user);

}
