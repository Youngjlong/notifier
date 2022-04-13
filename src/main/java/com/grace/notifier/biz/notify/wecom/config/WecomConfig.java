package com.grace.notifier.biz.notify.wecom.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "wecom")
@Data
public class WecomConfig {
    private Long agentId;

    private String corpId;

    private String corpSecret;
}
