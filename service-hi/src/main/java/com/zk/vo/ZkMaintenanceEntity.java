package com.zk.vo;

import com.zk.NotSign;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * @author Sang
 * @create 2022/8/17 9:17
 */
@Data
public class ZkMaintenanceEntity {

    /**
     * 众卡来源标识
     */
    @NotSign
    public static final String ZK_APPLY_SOURCE = "众卡";

    @ApiModelProperty("平台分配key")
    private String app_key;

    @ApiModelProperty("时间戳： yyyy-mm-dd hh:mm:ss  以字符串类型传输")
    private String timestamp;

    @ApiModelProperty("签名")
    @NotSign
    private String sign;

    @ApiModelProperty("维保商全称")
    private String servicerName;

    @ApiModelProperty("维保订单号 将来根据该数据推送维保订单审核结果")
    private String orderId;

    @ApiModelProperty("存放众卡任务编码 区别原维保与现任务维保")
    private String taskNo;

    @ApiModelProperty("维修主体 HEAD（车头）、HANGING（车挂）")
    private String repairPosition;

    @ApiModelProperty("车牌")
    private String carTrailerId;

    @ApiModelProperty("公里数 以字符串类型传输")
    private String mileage;

    @ApiModelProperty("业务性质（维修、保养）")
    private String businessNature;

    @ApiModelProperty("维保项列表费用总计 保留小数点后两位 以字符串类型传输")
    private String totalCost;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("操作人名称")
    private String reportName;

    @ApiModelProperty("服务站点名称")
    private String servicerSiteName;

    @ApiModelProperty("CHANGE：已变更服务商；THROW：任务废弃")
    private String notice;

    @ApiModelProperty("接单/退回")
    private ZkReceiveEnum receiveType;

    @NotSign
    @ApiModelProperty("请求众卡响应code ? 1:成功 : 失败")
    private Integer code;

    @NotSign
    @ApiModelProperty("请求众卡响应信息 请求成功/失败原因")
    private String message;

    @NotSign
    @ApiModelProperty("维保项列表，不参与验签")
    private List<ZkDetail> details;

    @ApiModelProperty("审核结果 通过 驳回 废弃")
    private String auditResult;

    @ApiModelProperty("审核备注")
    private String auditRemark;

    @NotSign
    @ApiModelProperty("保养任务 不参与验签")
    private List<ZkTask> taskList;

    @Data
    public static class ZkDetail {

        @ApiModelProperty("维保后照片组 （有效图片URL数组）")
        private List<String> afterPhotos;

        @ApiModelProperty("维保前照片组 （有效图片URL数组）")
        private List<String> beforePhotos;

        @ApiModelProperty("服务内容")
        private String serviceContent;

        @ApiModelProperty("单个维保项费用（明细费用detail_cost和）小数保留小数点后两位 以字符串类型传输")
        private String cost;

        @ApiModelProperty("材料明细列表，不参与验签")
        private List<ZkMaterial> materials;
    }

    @Data
    public static class ZkMaterial {

        @ApiModelProperty("明细")
        private String detail;

        @ApiModelProperty("数量 保留小数点后两位 以字符串类型传输")
        private String number;

        @ApiModelProperty("单价 保留小数点后两位 以字符串类型传输")
        private String unit_price;

        @ApiModelProperty("工时费 保留小数点后两位 以字符串类型传输")
        private String hour_cost;

        @ApiModelProperty("单个明细的费用合计（数量*单价）保留小数点后两位 以字符串类型传输")
        private String sum_cost;

        @ApiModelProperty("单个明细费用总计（数量*单价+工时费）保留小数点后两位  以字符串类型传输")
        private String detail_cost;

        @ApiModelProperty("备注")
        private String remark;
    }

    @Data
    public static class ZkTask {

        @ApiModelProperty("任务唯一编码(预留68位)")
        private String taskNo;

        @ApiModelProperty("车牌号")
        private String car;

        @ApiModelProperty("保养状态")
        private String status;

        @ApiModelProperty("司机姓名")
        private String driver;

        @ApiModelProperty("司机手机号")
        private String driverTel;

        @ApiModelProperty("车队长")
        private String captain;

        @ApiModelProperty("车队长手机号")
        private String captainTel;

        @ApiModelProperty("建议保养开始时间")
        private String adviceStartTime;

        @ApiModelProperty("建议保养结束时间")
        private String adviceEndTime;

        @ApiModelProperty("当前累计里程（公里）")
        private String totalMileage;

        @ApiModelProperty("需保养里程（公里）")
        private String maintainMileage;

        @ApiModelProperty("保养材料明细")
        private List<Material> materialList;

        @ApiModelProperty("其他")
        private List<Other> other;
    }

    @Data
    public static class Material {

        @ApiModelProperty("材料明细编码(预留64位)")
        private String materialId;

        @ApiModelProperty("配件名称")
        private String partName;

        @ApiModelProperty("配件品牌")
        private String partBrand;

        @ApiModelProperty("配件型号")
        private String partModel;

        @ApiModelProperty("数量")
        private String partNum;

        @ApiModelProperty("单价")
        private String unitPrice;

        @ApiModelProperty("工时费")
        private String hourCost;

        @ApiModelProperty("总价（单价*数量+工时费）")
        private String totalCost;
    }

    @Data
    public static class Other {

        @ApiModelProperty("项目名")
        private String businessName;

        @ApiModelProperty("项目金额（总价和）")
        private String businessCost;

        @ApiModelProperty("工时费总金额（工时费和）")
        private String hourCostTotal;
    }

    public enum ZkReceiveEnum {
        //报修申请接单
        RECEIVED,
        //报修申请退回
        RETURN;
    }

    @AllArgsConstructor
    @Getter
    public enum ZkAuditResultEnum {
        //审核结果
        //通过
        THROUGH(1, "通过"),
        //驳回
        REJECTED(2, "驳回"),
        //废弃
        ABANDONED(3, "废弃");

        public final Integer status;

        public final String name;
    }


}
