package com.boer;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(value = "终端设备绑定信息", description = "")
public class DeviceBindSensorVm   {

    @ApiModelProperty(value = "设备id", example = "33d433", required = false)
    private String deviceId;

    @ApiModelProperty(value = "车牌号", example = "沪D96396", required = false)
    private String licensePlate;

    @ApiModelProperty(value = "传感器id", example = "e6396", required = false)
    private String sensorId;

    /**
     * 轮位,传感器ID 数组
     */
    @ApiModelProperty(value = "轮位,传感器ID 数组", required = true)
    private List<DeviceTyreLocationSensorParam> tyreLocationInfo;

    /**
     * (原始)轮位,传感器ID 数组
     */
    @ApiModelProperty(value = "(原始)轮位,传感器ID 数组", required = true)
    private List<DeviceTyreLocationSensorParam> originalTyreLocationInfo;



    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id", required = true)
    private Integer commodityId;

    @ApiModelProperty(value = "小管家车牌号", example = "沪D96396", required = false)
    private String licensePlateManage;

    @ApiModelProperty(value = "原设备id", example = "33d433", required = false)
    private String originalDeviceId;

    /**
     * 设备品牌类型
     */
    private String manufacturerId;

    /**
     * 动作类型：1.主机 ,2传感器
     */
    private Integer actionType;

    /**
     * 安装设备
     */
    private DeviceStockHardSoftParam installHardSoft;

    /**
     * 拆卸设备
     */
    private DeviceStockHardSoftParam disassembleHardSoft;

    /**
     * 设备信息
     */
    private DeviceStockHardSoftParam lossHardSoft;
}
