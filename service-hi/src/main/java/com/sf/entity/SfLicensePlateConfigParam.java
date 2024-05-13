package com.sf.entity;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class SfLicensePlateConfigParam {
    /**
     * 车牌号
     */
    private Set<String> licensePlates;

    /**
     * 新增:0  删除:1
     */
    private Integer isDeleted;

}