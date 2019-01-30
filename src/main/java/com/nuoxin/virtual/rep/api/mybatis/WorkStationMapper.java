package com.nuoxin.virtual.rep.api.mybatis;

import com.nuoxin.virtual.rep.api.web.controller.request.WorkStationRequestBean;
import com.nuoxin.virtual.rep.api.web.controller.response.work.*;


import java.util.List;
import java.util.Map;

/**
 * Create by tiancun on 2017/10/16
 */
public interface WorkStationMapper {

    List<CustomerSumResponseBean> getTotalCustomerStatistic(WorkStationRequestBean bean);

    List<CustomerSumResponseBean> getAddCustomerStatistic(WorkStationRequestBean bean);

    List<CustomerSumResponseBean> getCoverCustomerStatistic(WorkStationRequestBean bean);

    List<OneMonthNoFollowCustomerResponseBean> getOneMonthNoFollowCustomerList(WorkStationRequestBean bean);

    Integer getOneMonthNoFollowCustomerListCount(WorkStationRequestBean bean);

    List<DrugUserInteractResponseBean> drugUserInteract(WorkStationRequestBean bean);


    /**
     * 坐席分析
     */
    //总通话时间最短
    //Integer minCallTotalTime(WorkStationRequestBean bean);
    List<DrugUserAnalysisResponseBean> minCallTotalTimeList(WorkStationRequestBean bean);

    //平均通话时间最短,按照次数
    Integer minAvgCallTotalTime(WorkStationRequestBean bean);
    List<DrugUserAnalysisResponseBean> minAvgCallTotalTimeList(WorkStationRequestBean bean);

    //电话数量最少
    Integer minCallCount(WorkStationRequestBean bean);
    List<DrugUserAnalysisResponseBean> minCallCountList(WorkStationRequestBean bean);

    //电话覆盖数量最少
    Integer minCallCoveredCount(WorkStationRequestBean bean);
    List<DrugUserAnalysisResponseBean> minCallCoveredCountList(WorkStationRequestBean bean);

    //总短信数量最少
    Integer minImCount(WorkStationRequestBean bean);
    List<DrugUserAnalysisResponseBean> minImCountList(WorkStationRequestBean bean);

    //短信覆盖客户数量最少
    Integer minImCoveredCount(WorkStationRequestBean bean);
    List<DrugUserAnalysisResponseBean> minImCoveredCountList(WorkStationRequestBean bean);

    //微信数量最少
    Integer minWechatCount(WorkStationRequestBean bean);
    List<DrugUserAnalysisResponseBean> minWechatCountList(WorkStationRequestBean bean);


    //微信覆盖客户数最少
    Integer minWechatCoveredCount(WorkStationRequestBean bean);
    List<DrugUserAnalysisResponseBean> minWechatCoveredCountList(WorkStationRequestBean bean);


    //邮件数量最少
    Integer minEmailCount(WorkStationRequestBean bean);
    List<DrugUserAnalysisResponseBean> minEmailCountList(WorkStationRequestBean bean);

    //邮件覆盖客户最少
    Integer minEmailCoveredCount(WorkStationRequestBean bean);
    List<DrugUserAnalysisResponseBean> minEmailCoveredCountList(WorkStationRequestBean bean);

    //通话未达标，按照人数
    List<String> callNoReach(WorkStationRequestBean bean);

    //微信未达标，按照人数
    List<String> wechatNoReach(WorkStationRequestBean bean);

    //短信未达标，按照人数
    List<String> imNoReach(WorkStationRequestBean bean);

    //邮件未达标，按照人数
    List<String> emailNoReach(WorkStationRequestBean bean);

    /**
     * 脱落客户最严重
     */

    //级别脱落总数
    Integer getDropCount(WorkStationRequestBean bean);

    //每个级别的最大脱落总数
    Integer maxDropCount(WorkStationRequestBean bean);

    //每个级别的最大脱落总数
    List<DrugUserAnalysisResponseBean> maxDropCountList(WorkStationRequestBean bean);

    /**
     * 客户分析
     */
    //总通话时间最短
    Integer minDoctorCallTotalTime(WorkStationRequestBean bean);
    List<DoctorAnalysisResponseBean> minDoctorCallTotalTimeList(WorkStationRequestBean bean);

    //平均通话时间最短,按照次数
    Integer minDoctorAvgCallTotalTime(WorkStationRequestBean bean);
    List<DoctorAnalysisResponseBean> minDoctorAvgCallTotalTimeList(WorkStationRequestBean bean);

    //电话数量最少
    Integer minDoctorCallCount(WorkStationRequestBean bean);
    List<DoctorAnalysisResponseBean> minDoctorCallCountList(WorkStationRequestBean bean);

    //电话次数数量最少
    Integer minDoctorCallCoveredCount(WorkStationRequestBean bean);
    List<DoctorAnalysisResponseBean> minDoctorCallCoveredCountList(WorkStationRequestBean bean);


    //总短信数量最少
    Integer minDoctorImCount(WorkStationRequestBean bean);
    List<DoctorAnalysisResponseBean> minDoctorImCountList(WorkStationRequestBean bean);


    //微信数量最少
    Integer minDoctorWechatCount(WorkStationRequestBean bean);
    List<DoctorAnalysisResponseBean> minDoctorWechatCountList(WorkStationRequestBean bean);

    //微信数量最少
    Integer minDoctorEmailCount(WorkStationRequestBean bean);
    List<DoctorAnalysisResponseBean> minDoctorEmailCountList(WorkStationRequestBean bean);

    //会议时间最少
//    Integer minDoctorMeetingTime(WorkStationRequestBean bean);
//    List<DoctorAnalysisResponseBean> minDoctorMeetingTimeList(WorkStationRequestBean bean);





//    //短信、微信、邮件的阅读时长,单位为秒
//    AnalysisResponseBean getMessageTime(WorkStationRequestBean bean);
//
//
//    //电话时长,单位为秒
//    Integer getCallTime(WorkStationRequestBean bean);
//
//
//    //会议时长,单位为分钟
//    Integer getMeeingTime(WorkStationRequestBean bean);
//
//
//    //最短的微信，短信，邮件阅读时长
//    Map<String,Integer> getMinMessageTime(WorkStationRequestBean bean);

    //微信阅读时长最少列表
    List<DrugUserAnalysisResponseBean> minWechatTimeList(WorkStationRequestBean bean);

    //短信阅读时长最少列表
    List<DrugUserAnalysisResponseBean> minImTimeList(WorkStationRequestBean bean);

    //邮件阅读时长最少列表
    List<DrugUserAnalysisResponseBean> minEmailTimeList(WorkStationRequestBean bean);


    //会议时长最少列表
    List<DrugUserAnalysisResponseBean> minMeetingTimeList(WorkStationRequestBean bean);

    //脱落客户的销售列表
    List<DrugUserAnalysisResponseBean> dropCustomerDrugUserList(WorkStationRequestBean bean);


    //微信阅读时长最少列表
    List<DoctorAnalysisResponseBean> minDoctorWechatTimeList(WorkStationRequestBean bean);

    //短信阅读时长最少列表
    List<DoctorAnalysisResponseBean> minDoctorImTimeList(WorkStationRequestBean bean);

    //邮件阅读时长最少列表
    List<DoctorAnalysisResponseBean> minDoctorEmailTimeList(WorkStationRequestBean bean);


    //会议时长最少列表
    List<DoctorAnalysisResponseBean> minDoctorMeetingTimeList(WorkStationRequestBean bean);




}