package com.grace.notifier.biz.notify.wecom.bo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class WecomMessageRequestBO {
    @SerializedName("touser")
    private String receiver;

    @SerializedName("msgtype")
    private String msgType;

    @SerializedName("agentid")
    private Long agentId;

    private WecomTextMsg text;
}
