package com.nuoxin.virtual.rep.api.service;

import com.nuoxin.virtual.rep.api.common.bean.PageResponseBean;
import com.nuoxin.virtual.rep.api.common.service.BaseService;
import com.nuoxin.virtual.rep.api.common.util.StringUtils;
import com.nuoxin.virtual.rep.api.dao.DoctorCallInfoRepository;
import com.nuoxin.virtual.rep.api.dao.DoctorQuestionnaireRepository;
import com.nuoxin.virtual.rep.api.dao.DoctorRepository;
import com.nuoxin.virtual.rep.api.entity.DoctorCallInfo;
import com.nuoxin.virtual.rep.api.entity.DoctorQuestionnaire;
import com.nuoxin.virtual.rep.api.enums.CallTypeEnum;
import com.nuoxin.virtual.rep.api.utils.DateUtil;
import com.nuoxin.virtual.rep.api.web.controller.request.QueryRequestBean;
import com.nuoxin.virtual.rep.api.web.controller.request.call.CallHistoryRequestBean;
import com.nuoxin.virtual.rep.api.web.controller.request.call.CallInfoRequestBean;
import com.nuoxin.virtual.rep.api.web.controller.request.call.CallRequestBean;
import com.nuoxin.virtual.rep.api.web.controller.request.question.QuestionRequestBean;
import com.nuoxin.virtual.rep.api.web.controller.request.question.QuestionnaireRequestBean;
import com.nuoxin.virtual.rep.api.web.controller.response.call.CallHistoryResponseBean;
import com.nuoxin.virtual.rep.api.web.controller.response.call.CallResponseBean;
import com.nuoxin.virtual.rep.api.web.controller.response.call.CallStatResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 9/13/17.
 */
@Service
@Transactional(readOnly = true)
public class DoctorCallService extends BaseService {

    @Autowired
    private DoctorQuestionnaireService doctorQuestionnaireService;

    @Autowired
    private DoctorCallInfoRepository doctorCallInfoRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    public PageResponseBean<CallResponseBean> doctorPage(QueryRequestBean bean){
        PageRequest pagetable = super.getPage(bean);
        Specification<DoctorCallInfo> spec = new Specification<DoctorCallInfo>() {
            @Override
            public Predicate toPredicate(Root<DoctorCallInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if(StringUtils.isNotEmtity(bean.getName())){
                    predicates.add(cb.like(root.get("doctor").get("name").as(String.class),"%"+bean.getName()+"%"));
                }
                if(StringUtils.isNotEmtity(bean.getMobile())){
                    predicates.add(cb.like(root.get("doctor").get("mobile").as(String.class),"%"+bean.getMobile()+"%"));
                }
                if(StringUtils.isNotEmtity(bean.getDepartment())){
                    predicates.add(cb.like(root.get("doctor").get("department").as(String.class),"%"+bean.getDepartment()+"%"));
                }
                if(StringUtils.isNotEmtity(bean.getDoctorLevel())){
                    predicates.add(cb.like(root.get("doctor").get("doctorLevle").as(String.class),"%"+bean.getDoctorLevel()+"%"));
                }
                if(StringUtils.isNotEmtity(bean.getHospital())){
                    predicates.add(cb.like(root.get("doctor").get("hospitalName").as(String.class),"%"+bean.getHospital()+"%"));
                }
                predicates.add(cb.like(root.get("doctor").get("drugUserIds").as(String.class),"%"+bean.getDrugUserId()+",%"));
                query.where(cb.and(cb.and(predicates.toArray(new Predicate[0]))));
                return query.getRestriction();
            }
        };
        Page<DoctorCallInfo> page = doctorCallInfoRepository.findAll(spec,pagetable);
        PageResponseBean<CallResponseBean> responseBean = new PageResponseBean<>(page);
        List<DoctorCallInfo> list = page.getContent();
        if(list!=null && !list.isEmpty()){
            List<CallResponseBean> responseBeans = new ArrayList<>();
            for (DoctorCallInfo info:list) {
                responseBeans.add(this._getCallResponseBean(info));
            }
            responseBean.setContent(responseBeans);
        }
        return responseBean;
    }

    public PageResponseBean<CallHistoryResponseBean> doctorHistoryPage(CallHistoryRequestBean bean){
        if(bean.getTimeLong()!=null && bean.getTimeLong()!=0){
            Integer count = doctorCallInfoRepository.findByCreateTimeCount(new Date(bean.getTimeLong()));
            if(count!=0){
                bean.setPage((int)Math.ceil(count.doubleValue()/bean.getPageSize()));
            }
        }
        PageRequest pagetable = super.getPage(bean);
        Specification<DoctorCallInfo> spec = new Specification<DoctorCallInfo>() {
            @Override
            public Predicate toPredicate(Root<DoctorCallInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(cb.like(root.get("doctor").get("drugUserIds").as(String.class),"%"+bean.getDrugUserId()+",%"));
                query.where(cb.and(cb.and(predicates.toArray(new Predicate[0]))));
                return query.getRestriction();
            }
        };
        Page<DoctorCallInfo> page = doctorCallInfoRepository.findAll(spec,pagetable);
        PageResponseBean<CallHistoryResponseBean> responseBean = new PageResponseBean<>(page);
        List<DoctorCallInfo> list = page.getContent();
        if(list!=null && !list.isEmpty()){
            List<CallHistoryResponseBean> responseBeans = new ArrayList<>();
            for (DoctorCallInfo info:list) {
                responseBeans.add(this._getCallHistoryResponseBean(info,bean.getTimeLong()));
            }
            responseBean.setContent(responseBeans);
        }
        return responseBean;
    }

    public CallStatResponseBean stat(Long drugUserId){
        CallStatResponseBean responseBean = new CallStatResponseBean();
        Map<String,Long> map = doctorCallInfoRepository.statDrugUserIds("%"+drugUserId+",%", CallTypeEnum.CALL_TYPE_CALLOUT.getType());
        Long callTimes = null;
        Long num = null;
        if(map!=null){
            responseBean.setCallOutAllNum(map.get("allNum").intValue());
            callTimes = map.get("callTimes");
            num = map.get("num");
            if(callTimes!=null){
                responseBean.setCallOutAllTimes(callTimes);
            }
            if(num!=null){
                responseBean.setCallOutNum(num.intValue());
            }


        }
        map = doctorCallInfoRepository.statDrugUserIds("%"+drugUserId+",%", CallTypeEnum.CALL_TYPE_INCALL.getType());
        if (map != null) {
            responseBean.setInCallAllNum(map.get("allNum").intValue());
            callTimes = map.get("callTimes");
            num = map.get("num");
            if(callTimes!=null){
                responseBean.setInCallAllTimes(callTimes);
            }
            if(num!=null){
                responseBean.setInCallNum(num.intValue());
            }


        }
        return responseBean;
    }

    @Transactional(readOnly = false)
    public CallRequestBean save(CallRequestBean bean){
        DoctorCallInfo info = new DoctorCallInfo();
        info.setDoctor(doctorRepository.findTopByMobile(bean.getMobile()));
        info.setSinToken(bean.getSinToken());
        info.setStatus(bean.getStatus());
        info.setStatusName(bean.getStatusName());
        info.setMobile(bean.getMobile());
        info.setType(bean.getType());
        info.setDrugUserId(bean.getDrugUserId());
        doctorCallInfoRepository.saveAndFlush(info);
        bean.setId(info.getId());
        return bean;
    }

    @Transactional(readOnly = false)
    public Boolean stopSave(CallInfoRequestBean bean){
        DoctorCallInfo info = doctorCallInfoRepository.findOne(bean.getId());
        if(info==null){
            return false;
        }
        info.setCallTime(bean.getTimes());
        info.setCallUrl(bean.getUrl());
        info.setRemark(bean.getRemark());
        //保存通话信息
        doctorCallInfoRepository.saveAndFlush(info);

        //保存问卷信息
        List<DoctorQuestionnaire> saveList = new ArrayList<>();
        List<QuestionnaireRequestBean> list = bean.getQuestions();
        if(list!=null && !list.isEmpty()){
            for (QuestionnaireRequestBean arb:list) {
                List<QuestionRequestBean> qs = arb.getQuestions();
                if(qs!=null && !qs.isEmpty()){
                    for (QuestionRequestBean qrb:qs) {
                        DoctorQuestionnaire dq = new DoctorQuestionnaire();
                        dq.setAnswer(qrb.getAnswer());
                        dq.setCreateTime(new Date());
                        dq.setDoctorId(info.getDoctor()==null?0l:info.getDoctor().getId());
                        dq.setDrugUserId(bean.getDrugUserId());
                        dq.setQuestionnaireId(arb.getId());
                        dq.setQuestionId(qrb.getId());
                        dq.setCallId(info.getId());
                        saveList.add(dq);
                    }
                }
            }
        }
        if(saveList!=null && !saveList.isEmpty()){
            doctorQuestionnaireService.save(saveList);
        }
        return true;
    }

    private CallHistoryResponseBean _getCallHistoryResponseBean(DoctorCallInfo info,Long timeLong){
        CallHistoryResponseBean callBean = new CallHistoryResponseBean();
        callBean.setDataUrl(info.getCallUrl());
        //callBean.setDoctorId(info.getDoctor().getId());
        //callBean.setQuestions();
        callBean.setRemark(info.getRemark());
        callBean.setTimeLong(info.getCreateTime().getTime());
        callBean.setTimes(info.getCallTime());
        callBean.setTimeStr(DateUtil.getDateTimeString(info.getCreateTime()));
        if(timeLong!=null && timeLong.equals(callBean.getTimeLong())){
            callBean.setCurrent(true);
        }

        //添加试题
        callBean.setQuestions(doctorQuestionnaireService.findByCallId(info.getId()));
        return callBean;
    }

    private CallResponseBean _getCallResponseBean(DoctorCallInfo info){
        CallResponseBean responseBean = new CallResponseBean();
        if(info!=null){
            responseBean.setClientLevel(info.getDoctor().getClientLevel());
            responseBean.setDoctorId(info.getDoctor().getId());
            responseBean.setDoctorMobile(info.getDoctor().getMobile());
            responseBean.setDoctorName(info.getDoctor().getName());
            responseBean.setTimeLong(info.getCreateTime().getTime());
            responseBean.setTimeStr(DateUtil.getDateTimeString(info.getCreateTime()));
        }
        return responseBean;
    }
}
