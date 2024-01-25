package com.zk.vo;

import com.zk.NotSign;
import lombok.Data;

@Data
public class MaintenanceWorkAudit {
    private String appKey;
    private String timestamp;
    private String sign;
    private String orderId;
    private String auditResult;
    @NotSign
    private String auditRemark;
}
