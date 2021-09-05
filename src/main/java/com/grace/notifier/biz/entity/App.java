package com.grace.notifier.biz.entity;

import com.grace.notifier.core.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class App extends BaseEntity {
    private String name;

    private String accessKey;

    private String secretKey;
}
