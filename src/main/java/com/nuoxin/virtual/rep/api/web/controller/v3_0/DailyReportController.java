package com.nuoxin.virtual.rep.api.web.controller.v3_0;

import com.nuoxin.virtual.rep.api.common.bean.DefaultResponseBean;
import com.nuoxin.virtual.rep.api.common.enums.ErrorEnum;
import com.nuoxin.virtual.rep.api.common.exception.BusinessException;
import com.nuoxin.virtual.rep.api.entity.DrugUser;
import com.nuoxin.virtual.rep.api.service.v3_0.DailyReportService;
import com.nuoxin.virtual.rep.api.utils.DateUtil;
import com.nuoxin.virtual.rep.api.utils.StringUtil;
import com.nuoxin.virtual.rep.api.web.controller.request.v3_0.DailyReportRequest;
import com.nuoxin.virtual.rep.api.web.controller.response.v3_0.DailyReportResponse;
import com.nuoxin.virtual.rep.api.web.controller.response.v3_0.daily.*;
import com.nuoxin.virtual.rep.api.web.controller.v2_5.NewBaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 我的客户相关接口
 * @author tiancun
 * @date 2019-04-28
 */
@RestController
@Api(value = "V3.0.1日报接口")
@RequestMapping(value = "/daily/report")
public class DailyReportController extends NewBaseController {

    @Resource
    private DailyReportService dailyReportService;

    @ApiOperation(value = "展示数据")
    @PostMapping(value = "/detail")
    public DefaultResponseBean<DailyReportResponse> getDailyReport(@RequestBody DailyReportRequest request){
        DailyReportResponse dailyReport = dailyReportService.getDailyReport(request);
        DefaultResponseBean<DailyReportResponse> responseBean = new DefaultResponseBean<>();
        responseBean.setData(dailyReport);
        return responseBean;
    }


    @ApiOperation(value = "我的业绩")
    @PostMapping(value = "/my/achievement")
    public DefaultResponseBean<MyAchievementResponse> getMyAchievement(@RequestBody DailyReportRequest request){
        MyAchievementResponse myAchievement = dailyReportService.getMyAchievement(request);
        DefaultResponseBean<MyAchievementResponse> responseBean = new DefaultResponseBean<>();
        responseBean.setData(myAchievement);
        return responseBean;
    }

    @ApiOperation(value = "我的业绩导出")
    @GetMapping(value = "/my/achievement/export")
    public void exportMyAchievement(HttpServletRequest request, HttpServletResponse response){
        DailyReportRequest bean = this.getExportParmas(request);
        dailyReportService.exportMyAchievement(bean, response);
    }


    @ApiOperation(value = "我的业绩,已招募医生导出")
    @GetMapping(value = "/my/achievement/recruit/doctor/export")
    public void exportMyAchievementRecruitDoctor(HttpServletRequest request, HttpServletResponse response){
        DailyReportRequest bean = this.getExportParmas(request);
        dailyReportService.exportMyAchievementRecruitDoctor(bean, response);
    }


    @ApiOperation(value = "我的业绩,活跃覆盖医生导出")
    @GetMapping(value = "/my/achievement/activity/doctor/export")
    public void exportMyAchievementActivityDoctor(HttpServletRequest request, HttpServletResponse response){
        DailyReportRequest bean = this.getExportParmas(request);
        dailyReportService.exportMyAchievementActivityDoctor(bean, response);
    }


    @ApiOperation(value = "我的业绩,多渠道覆盖医生导出")
    @GetMapping(value = "/my/achievement/mul/channel/doctor/export")
    public void exportMyAchievementMulChannelDoctor(HttpServletRequest request, HttpServletResponse response){
        DailyReportRequest bean = this.getExportParmas(request);
        dailyReportService.exportMyAchievementMulChannelDoctor(bean, response);
    }



    @ApiOperation(value = "电话拜访统计")
    @PostMapping(value = "/call/statistics")
    public DefaultResponseBean<CallVisitStatisticsResponse> getCallVisitStatistics(@RequestBody DailyReportRequest request){
        CallVisitStatisticsResponse callVisitStatistics = dailyReportService.getCallVisitStatistics(request);
        DefaultResponseBean<CallVisitStatisticsResponse> responseBean = new DefaultResponseBean<>();
        responseBean.setData(callVisitStatistics);
        return responseBean;
    }


    @ApiOperation(value = "不同渠道拜访医生人数统计")
    @PostMapping(value = "/visit/channel/doctor/num")
    public DefaultResponseBean<List<VisitChannelDoctorNumResponse>> getVisitChannelDoctorNum(@RequestBody DailyReportRequest request){
        List<VisitChannelDoctorNumResponse> visitChannelDoctorNumList = dailyReportService.getVisitChannelDoctorNumList(request);
        DefaultResponseBean<List<VisitChannelDoctorNumResponse>> responseBean = new DefaultResponseBean<>();
        responseBean.setData(visitChannelDoctorNumList);
        return responseBean;
    }


    @ApiOperation(value = "不同拜访结果医生人数统计")
    @PostMapping(value = "/visit/result/doctor/num")
    public DefaultResponseBean<List<VisitResultDoctorNumStatisticsResponse>> getVisitResultDoctorNum(@RequestBody DailyReportRequest request){
        List<VisitResultDoctorNumStatisticsResponse> visitResultDoctorNum = dailyReportService.getVisitResultDoctorNum(request);
        DefaultResponseBean<List<VisitResultDoctorNumStatisticsResponse>> responseBean = new DefaultResponseBean<>();
        responseBean.setData(visitResultDoctorNum);
        return responseBean;
    }


    @ApiOperation(value = "不同拜访结果医院人数统计")
    @PostMapping(value = "/visit/result/hospital/num")
    public DefaultResponseBean<List<VisitResultHospitalNumStatisticsResponse>> getVisitResultHospitalNum(@RequestBody DailyReportRequest request){
        List<VisitResultHospitalNumStatisticsResponse> visitResultHospitalNum = dailyReportService.getVisitResultHospitalNum(request);
        DefaultResponseBean<List<VisitResultHospitalNumStatisticsResponse>> responseBean = new DefaultResponseBean<>();
        responseBean.setData(visitResultHospitalNum);
        return responseBean;
    }



    @ApiOperation(value = "不同拜访结果类型医生人数统计")
    @PostMapping(value = "/visit/result/type/doctor/num")
    public DefaultResponseBean<List<VisitTypeDoctorNumStatisticsResponse>> getVisitTypeDoctorNum(@RequestBody DailyReportRequest request){
        List<VisitTypeDoctorNumStatisticsResponse> visitTypeDoctorNum = dailyReportService.getVisitTypeDoctorNum(request);
        DefaultResponseBean<List<VisitTypeDoctorNumStatisticsResponse>> responseBean = new DefaultResponseBean<>();
        responseBean.setData(visitTypeDoctorNum);
        return responseBean;
    }


    @ApiOperation(value = "不同拜访结果类型医院人数统计")
    @PostMapping(value = "/visit/result/type/hospital/num")
    public DefaultResponseBean<List<VisitTypeHospitalNumStatisticsResponse>> getVisitTypeHospitalNum(@RequestBody DailyReportRequest request){
        List<VisitTypeHospitalNumStatisticsResponse> visitTypeHospitalNum = dailyReportService.getVisitTypeHospitalNum(request);
        DefaultResponseBean<List<VisitTypeHospitalNumStatisticsResponse>> responseBean = new DefaultResponseBean<>();
        responseBean.setData(visitTypeHospitalNum);
        return responseBean;
    }




    @ApiOperation(value = "招募医生统计")
    @PostMapping(value = "/doctor/recruit")
    public DefaultResponseBean<DoctorRecruitResponse> getDoctorRecruit(@RequestBody DailyReportRequest request){
        DoctorRecruitResponse doctorRecruit = dailyReportService.getDoctorRecruit(request);
        DefaultResponseBean<DoctorRecruitResponse> responseBean = new DefaultResponseBean<>();
        responseBean.setData(doctorRecruit);
        return responseBean;
    }


    @ApiOperation(value = "招募医院统计")
    @PostMapping(value = "/hospital/recruit")
    public DefaultResponseBean<HospitalRecruitResponse> getHospitalRecruit(@RequestBody DailyReportRequest request){
        HospitalRecruitResponse hospitalRecruit = dailyReportService.getHospitalRecruit(request);
        DefaultResponseBean<HospitalRecruitResponse> responseBean = new DefaultResponseBean<>();
        responseBean.setData(hospitalRecruit);
        return responseBean;
    }


    @ApiOperation(value = "医生其他维度统计")
    @PostMapping(value = "/doctor/visit")
    public DefaultResponseBean<DoctorVisitResponse> getDoctorVisit(@RequestBody DailyReportRequest request){
        DoctorVisitResponse doctorVisit = dailyReportService.getDoctorVisit(request);
        DefaultResponseBean<DoctorVisitResponse> responseBean = new DefaultResponseBean<>();
        responseBean.setData(doctorVisit);
        return responseBean;
    }



    @ApiOperation(value = "导出")
    @GetMapping(value = "/export")
    public void exportDailyReport(HttpServletRequest request, HttpServletResponse response){
        DrugUser drugUser = super.getDrugUser(request);
        DailyReportRequest bean = this.getExportParmas(request);
        dailyReportService.exportDailyReport(response, bean, drugUser);

    }


    /**
     * 得到导出请求参数
     * @param request
     * @return
     */
    private DailyReportRequest getExportParmas(HttpServletRequest request) {
        String productIdStr = request.getParameter("productIdStr");
        String drugUserIdStr = request.getParameter("drugUserIdStr");
        String startTimeStr = request.getParameter("startTime");
        String endTimeStr = request.getParameter("endTime");
        List<Long> productIdList;
        List<Long> drugUserIdList;

        try {
            productIdList = StringUtil.getIdList(productIdStr);
        }catch (Exception e){
            throw new BusinessException(ErrorEnum.ERROR, "产品ID输入不合法，多个以逗号分开");
        }

        try {
            drugUserIdList = StringUtil.getIdList(drugUserIdStr);
        }catch (Exception e){
            throw new BusinessException(ErrorEnum.ERROR, "代表ID输入不合法，多个以逗号分开");
        }

        Date startTime = DateUtil.stringToDate(startTimeStr, DateUtil.DATE_FORMAT_YMD);
        Date endTime = DateUtil.stringToDate(endTimeStr, DateUtil.DATE_FORMAT_YMD);

        DailyReportRequest dailyReportRequest = new DailyReportRequest();
        dailyReportRequest.setDrugUserIdList(drugUserIdList);
        dailyReportRequest.setProductIdList(productIdList);
        dailyReportRequest.setStartTime(startTime);
        dailyReportRequest.setEndTime(endTime);

        return dailyReportRequest;
    }


}
