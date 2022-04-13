package com.grace.notifier.biz.notify.wecom.bo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class WecomTokenBO {
    /**
     * 错误代码
     */
    private Long errcode;

    /**
     * 错误信息
     */
    private String errmsg;

    /**
     * token
     */
    @SerializedName("access_token")
    private String accessToken;

    /**
     * 有效期
     */
    @SerializedName("expires_in")
    private Long expiresIn;
}
