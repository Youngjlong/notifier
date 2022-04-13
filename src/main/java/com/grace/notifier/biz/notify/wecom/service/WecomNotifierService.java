package com.grace.notifier.biz.notify.wecom.service;

import com.grace.notifier.biz.notify.message.TextMessage;
import com.grace.notifier.biz.notify.wecom.bo.WecomMessageResultBO;

public interface WecomNotifierService {
    String getWecomeToken();

    WecomMessageResultBO sendMessage(TextMessage textMessage);
}
