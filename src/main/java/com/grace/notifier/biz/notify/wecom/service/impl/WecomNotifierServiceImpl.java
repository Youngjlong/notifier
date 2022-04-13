package com.grace.notifier.biz.notify.wecom.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpUtil;
import com.google.gson.Gson;
import com.grace.notifier.biz.notify.message.TextMessage;
import com.grace.notifier.biz.notify.wecom.bo.WecomMessageRequestBO;
import com.grace.notifier.biz.notify.wecom.bo.WecomMessageResultBO;
import com.grace.notifier.biz.notify.wecom.bo.WecomTextMsg;
import com.grace.notifier.biz.notify.wecom.bo.WecomTokenBO;
import com.grace.notifier.biz.notify.wecom.config.WecomConfig;
import com.grace.notifier.biz.notify.wecom.service.WecomNotifierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class WecomNotifierServiceImpl implements WecomNotifierService {
    private static final String GET_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s";

    private static final String SEND_MESSAGE_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=%s";

    @Resource
    private WecomConfig wecomConfig;

    /**
     * @return
     * @link https://developer.work.weixin.qq.com/document/path/90236
     */
    @Override
    public String getWecomeToken() {
        String tokenUrl = String.format(GET_TOKEN_URL, URLUtil.encode(wecomConfig.getCorpId()), URLUtil.encode(wecomConfig.getCorpSecret()));
        Gson gson = new Gson();
        String result = HttpUtil.get(tokenUrl);
        WecomTokenBO wecomeToken = gson.fromJson(result, WecomTokenBO.class);

        return wecomeToken.getAccessToken();
    }

    @Override
    public WecomMessageResultBO sendMessage(TextMessage textMessage) {
        String sendUrl = String.format(SEND_MESSAGE_URL, URLUtil.encode(getWecomeToken()));

        WecomMessageRequestBO wecomMessageRequest = new WecomMessageRequestBO();
        wecomMessageRequest.setText(BeanUtil.copyProperties(textMessage, WecomTextMsg.class));
        wecomMessageRequest.setMsgType("text");
        wecomMessageRequest.setReceiver("@all");
        wecomMessageRequest.setAgentId(wecomConfig.getAgentId());

        Gson gson = new Gson();
        String result = HttpUtil.post(sendUrl, gson.toJson(wecomMessageRequest));

        log.info(result);

        return gson.fromJson(result, WecomMessageResultBO.class);
    }
}
