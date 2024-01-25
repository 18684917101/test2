package com.zk.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public  class MaintenanceWorkOrderDetailsToZk {

        @ApiModelProperty(value = "服务内容", required = true)
        private String serviceContent;

        @ApiModelProperty(value = "单个维保项费用（明细费用detail_cost和）小数保留小数点后两位 以字符串类型传输", required = true)
        private String cost;

        @ApiModelProperty(value = "材料明细列表，不参与验签", required = true)
        private List<MaterialToZkDetail> materials;

    }