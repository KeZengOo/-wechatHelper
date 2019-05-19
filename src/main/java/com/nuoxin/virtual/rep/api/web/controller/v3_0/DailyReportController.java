package com.nuoxin.virtual.rep.api.web.controller.v3_0;

import com.nuoxin.virtual.rep.api.common.bean.DefaultResponseBean;
import com.nuoxin.virtual.rep.api.entity.DrugUser;
import com.nuoxin.virtual.rep.api.service.v3_0.DailyReportService;
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



    private DailyReportRequest getExportParmas(HttpServletRequest request) {



        return null;
    }


}
