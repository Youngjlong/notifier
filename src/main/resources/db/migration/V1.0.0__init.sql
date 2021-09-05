CREATE TABLE `app`
(
    `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `name`         varchar(255) NOT NULL COMMENT '应用名称',
    `access_key`   varchar(48) NOT NULL,
    `secret_key`   varchar(48)  NOT NULL,
    `created_time` TIMESTAMP NULL DEFAULT NULL COMMENT '创建时间',
    `updated_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_access_key` (`access_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
