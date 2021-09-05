package com.grace.notifier.biz.service;

import com.grace.notifier.biz.entity.App;
import com.grace.notifier.dto.AppCreationDTO;

public interface AppService {
    App createApp(AppCreationDTO dto);

    App getAppByAccessKey(String secret);
}
