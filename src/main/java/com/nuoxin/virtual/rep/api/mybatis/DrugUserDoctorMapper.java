package com.nuoxin.virtual.rep.api.mybatis;

import java.util.List;

import com.nuoxin.virtual.rep.api.entity.v2_5.DrugUserDoctorParams;

/**
 * drug_user_doctor Mapper 类
 * @author xiekaiyu
 */
public interface DrugUserDoctorMapper {

	/**
	 * 指保保存至 drug_user_doctor 表
	 * @param list
	 * @return
	 */
	int saveDrugUserDoctors(List<DrugUserDoctorParams> list);
	
}
