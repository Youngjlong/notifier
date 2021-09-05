package com.grace.notifier.biz.service.impl;

import cn.hutool.core.util.IdUtil;
import com.grace.notifier.biz.entity.App;
import com.grace.notifier.biz.mapper.AppMapper;
import com.grace.notifier.biz.repository.AppRepository;
import com.grace.notifier.biz.service.AppService;
import com.grace.notifier.dto.AppCreationDTO;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {
    private final AppRepository appRepository;
    private final AppMapper appMapper;

    public AppServiceImpl(AppRepository appRepository, AppMapper appMapper) {
        this.appRepository = appRepository;
        this.appMapper = appMapper;
    }

    @Override
    public App createApp(AppCreationDTO dto) {
        App app = appMapper.toEntity(dto);
        app.setAccessKey(IdUtil.objectId());
        app.setSecretKey(IdUtil.simpleUUID());
        return appRepository.save(app);
    }

    @Override
    public App getAppByAccessKey(String accessKey) {
        return appRepository.getAppByAccessKey(accessKey);
    }
}
