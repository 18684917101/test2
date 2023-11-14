package com.boer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel("轮位传感器请求参数")
@Data
public class DeviceTyreLocationSensorParam {

    @ApiModelProperty(value = "主键id", required = true)
    private int id;

    @ApiModelProperty(value = "轮位编号", required = true)
    private int tyreLocationId;

    @ApiModelProperty(value = "轮位编号", required = true)
    private int tyreLocation;

    @ApiModelProperty(value = "传感器ID", required = true)
    private String sensorId;

    @ApiModelProperty(value = "商品id", required = true)
    private Integer commodityId;



}
