package com.boer;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("下发获取需改变库存的主机或传感器")
public class DeviceStockHardSoftParam {
    /**
     * 设备id
     */
    private String deviceId;

    /**
     * 设备id
     */
    private String sensorId;

    /**
     * install|disassemble|loss
     */
    private String hardSoftAction;

    /**
     * 1.主机 2、传感器
     */
    private String actionType;



    /**
     * 车牌号
     */
    private String licensePlate;



    /**
     * 硬件状态id
     */
    private Integer hardwareId;

    /**
     * 硬件状态名称
     */
    private String hardware;

    /**
     * 安装时候获取的所有库存汇总表id
     */
    private Integer stockGatherId;

    /**
     * 轮位
     */
    private Integer tyreLocationId;

    /**
     * 商品id
     */
    private Integer commodityId;

    /**
     * 拆除的商品id
     */
    private Integer disassembleCommodityId;

    /**
     * 丢弃的商品id
     */
    private Integer lossCommodityId;

    /**
     * groupbyKey
     */
    private String groupbyKey;

    /**
     * 出入库code: 拆卸入库code：3 ，安装出库code：11
     */
    private Integer stockCode;

    /**
     * 出入库数量
     */
    private Integer quantity;
}
