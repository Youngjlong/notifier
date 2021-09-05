package com.grace.notifier.biz.mapper;

import com.grace.notifier.biz.entity.App;
import com.grace.notifier.dto.AppCreationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppMapper {
    App toEntity(AppCreationDTO creationDTO);
}
