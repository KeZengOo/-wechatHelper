package com.nuoxin.virtual.rep.api.service.v3_0;

import com.nuoxin.virtual.rep.api.common.bean.PageResponseBean;
import com.nuoxin.virtual.rep.api.entity.DrugUser;
import com.nuoxin.virtual.rep.api.web.controller.request.v3_0.MyDoctorRequest;
import com.nuoxin.virtual.rep.api.web.controller.response.v3_0.MyDoctorResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * 我的客户相关接口
 * @author tiancun
 * @date 2019-04-28
 */
public interface MyDoctorService {


    /**
     * 得到我的客户医生列表
     * @param drugUser 登录用户
     * @param request  请求参数
     * @return
     */
    PageResponseBean<MyDoctorResponse> getDoctorPage(DrugUser drugUser,  MyDoctorRequest request);



}