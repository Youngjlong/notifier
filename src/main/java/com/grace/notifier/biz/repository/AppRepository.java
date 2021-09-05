package com.grace.notifier.biz.repository;

import com.grace.notifier.biz.entity.App;
import com.grace.notifier.core.base.BaseRepository;

public interface AppRepository extends BaseRepository<App> {
    App getAppByAccessKey(String accessKey);
}
