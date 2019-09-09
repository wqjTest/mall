package com.atongmu.mall.common.util.baseEntity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: mall
 * @description: 基础实体类
 * @author: Hus
 * @create: 2018-12-26 23:25
 */
@Data
public class BaseEntity {

    private String id;
    private String createBy;
    private LocalDateTime createDate;
    private String updateBy;
    private LocalDateTime updateDate;
    private Integer delFlag;
    private String remarks;

    public BaseEntity() {
    }

}