package com.nuoxin.virtual.rep.api.mybatis;

import com.nuoxin.virtual.rep.api.web.controller.request.WorkStationRequestBean;
import com.nuoxin.virtual.rep.api.web.controller.request.message.MessageRequestBean;
import com.nuoxin.virtual.rep.api.web.controller.response.message.MessageLinkmanResponseBean;
import com.nuoxin.virtual.rep.api.web.controller.response.message.MessageResponseBean;
import com.nuoxin.virtual.rep.api.web.controller.response.work.TodayStatisticsResponseBean;

import java.util.List;

/**
 * Create by tiancun on 2017/10/12
 */
public interface MessageMapper {


    TodayStatisticsResponseBean getMessageStatistics(WorkStationRequestBean bean);



    //微信和短信的联系人
    List<MessageLinkmanResponseBean> getMessageLinkmanList(MessageRequestBean bean);

    //微信和短信的联系人总数
    Integer getMessageLinkmanListCount(MessageRequestBean bean);

    //得到消息微信或者短信，短信添加产品，微信没有加
    List<MessageResponseBean> getMessageList(MessageRequestBean bean);

    //消息总数
    Integer getMessageListCount(MessageRequestBean bean);

    //今日会话数
    Integer messageCount(MessageRequestBean bean);



}