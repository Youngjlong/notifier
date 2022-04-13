package com.grace.notifier.biz.notify.wecom.bo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class WecomMessageResultBO {
    /**
     * 错误代码
     */
    private Long errcode;

    /**
     * 错误信息
     */
    private String errmsg;

    @SerializedName("msgid")
    private String msgId;
}
