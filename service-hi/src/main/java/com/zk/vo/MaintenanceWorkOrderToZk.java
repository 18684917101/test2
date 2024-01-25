package com.zk.vo;


import com.zk.NotSign;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 维保工单推送众卡数据对象
 */
@Data
public class MaintenanceWorkOrderToZk {

    @ApiModelProperty(value = "平台分配key", required = true)
    private String app_key;

    @ApiModelProperty(value = "时间戳： yyyy-mm-dd hh:mm:ss 以字符串类型传输", required = true)
    private String timestamp;

    @ApiModelProperty(value = "签名", required = true)
    @NotSign
    private String sign;

    @ApiModelProperty(value = "维保商全称", required = true)
    private String servicerName;

    @ApiModelProperty(value = "维保订单号 将来根据该数据推送维保订单审核结果", required = true)
    private String orderId;

    @ApiModelProperty(value = "众卡任务编码（取众卡任务接口taskNo字段值） 仅用于任务维保推送", required = false)
    private String taskNo;

    @ApiModelProperty(value = "维修主体 HEAD（车头）、HANGING（车挂）", required = true)
    private String repairPosition;

    @ApiModelProperty(value = "车牌", required = true)
    private String carTrailerId;

    @ApiModelProperty(value = "公里数 以字符串类型传输", required = false)
    private String mileage;

    @ApiModelProperty(value = "业务性质（维修、保养）", required = true)
    private String businessNature;

    @ApiModelProperty(value = "维保项列表费用总计 保留小数点后两位 以字符串类型传输", required = true)
    private String totalCost;

    @ApiModelProperty(value = "备注", required = false)
    private String remark;

    @ApiModelProperty(value = "操作人名称", required = true)
    private String reportName;

    @ApiModelProperty(value = "服务站点名称", required = true)
    private String servicerSiteName;

    @ApiModelProperty(value = "维保后照片组 （有效图片URL数组）", required = false)
    @NotSign
    private List<String> photoAfterMaintain;

    @ApiModelProperty(value = "维保前照片组 （有效图片URL数组）", required = false)
    @NotSign
    private List<String> beforePhotos;

//    @ApiModelProperty(value = "服务内容", required = true)
//    private String serviceContent;
//
//    @ApiModelProperty(value = "单个维保项费用（明细费用detail_cost和）小数保留小数点后两位 以字符串类型传输", required = true)
//    private String cost;

    @ApiModelProperty(value = "材料明细列表", required = true)
    @NotSign
    private List<MaintenanceWorkOrderDetailsToZk> details;




}
