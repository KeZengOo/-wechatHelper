package com.nuoxin.virtual.rep.api.web.schedule;

import com.nuoxin.virtual.rep.api.common.bean.DefaultResponseBean;
import com.nuoxin.virtual.rep.api.service.CallBackService;
import com.nuoxin.virtual.rep.api.web.controller.request.call.Call7mmorRequestBean;
import com.nuoxin.virtual.rep.api.web.controller.request.call.IdentifyCallUrlRequestBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * V2.5电话记录补偿,手动调用
 * @author tiancun
 * @date 2018-09-30
 */
@RestController
@Api(value = "V2.5电话记录补偿手动调用")
@RequestMapping(value = "/call/info")
public class CallInfoScheduleController {

    private static final Logger logger = LoggerFactory.getLogger(CallInfoScheduleController.class);

    @Resource
    private CallBackService callBackService;

    @ApiOperation(value = "没有回调的电话记录重试", notes = "没有回调的电话记录重试")
    @PostMapping(value = "/retry")
    public DefaultResponseBean<String> repeatSaveOrUpdateCall(@RequestBody Call7mmorRequestBean bean) {
        logger.info("CallInfoScheduleController repeatSaveOrUpdateCall start....");
        long starTime = System.currentTimeMillis();
        callBackService.repeatSaveOrUpdateCall(bean);
        long endTime = System.currentTimeMillis();
        logger.info("CallInfoScheduleController repeatSaveOrUpdateCall end , cost {}s", (endTime-starTime)/1000);

        DefaultResponseBean<String> responseBean = new DefaultResponseBean<>();
        responseBean.setData("success");
        return responseBean;
    }



    @ApiOperation(value = "识别录音文件", notes = "识别录音文件")
    @PostMapping(value = "/url/identify")
    public DefaultResponseBean<String> identifyCallUrl(@RequestBody IdentifyCallUrlRequestBean bean) {
        logger.info("CallInfoScheduleController identifyCallUrl start....");
        long starTime = System.currentTimeMillis();
        Integer limitNum = bean.getLimitNum();
        if (limitNum == null){
            // 如果没有就设置300
            bean.setLimitNum(300);
        }

        callBackService.identifyCallUrl(bean);
        long endTime = System.currentTimeMillis();
        logger.info("CallInfoScheduleController identifyCallUrl end , cost {}s", (endTime-starTime)/1000);

        DefaultResponseBean<String> responseBean = new DefaultResponseBean<>();
        responseBean.setData("success");
        return responseBean;
    }


    @ApiOperation(value = "识别录音文件", notes = "识别录音文件")
    @GetMapping(value = "/not/aliyun/url/update")
    public DefaultResponseBean<String> handleNotAliyunCallUrl() {
        logger.info("CallInfoScheduleController handleNotAliyunCallUrl start....");
        long starTime = System.currentTimeMillis();
        callBackService.handleNotAliyunCallUrl();
        long endTime = System.currentTimeMillis();
        logger.info("CallInfoScheduleController handleNotAliyunCallUrl end , cost {}s", (endTime-starTime)/1000);

        DefaultResponseBean<String> responseBean = new DefaultResponseBean<>();
        responseBean.setData("success");
        return responseBean;
    }


}