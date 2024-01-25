package com.zk.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
    public  class MaterialToZkDetail {

        @ApiModelProperty(value = "明细", required = true)
        private String detail;

        @ApiModelProperty(value = "数量 保留小数点后两位 以字符串类型传输", required = true)
        private String number;

        @ApiModelProperty(value = "单价 保留小数点后两位 以字符串类型传输", required = true)
        private String unit_price;

        @ApiModelProperty(value = "工时费 保留小数点后两位 以字符串类型传输", required = true)
        private String hour_cost;

        @ApiModelProperty(value = "单个明细的费用合计（数量*单价）保留小数点后两位 以字符串类型传输", required = true)
        private String sum_cost;

        @ApiModelProperty(value = "单个明细费用总计（数量*单价+工时费）保留小数点后两位 以字符串类型传输", required = true)
        private String detail_cost;

        @ApiModelProperty(value = "备注", required = false)
        private String remark;

    }