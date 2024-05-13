package com.sf.entity;

import com.alibaba.excel.annotation.ExcelProperty;

public class SFPushStatus {
    // 传感器编号
    @ExcelProperty(index = 0)
    private String sensorNo;
    // 车牌号
    @ExcelProperty(index = 1)
    private String carrierNo;
    // 传感器状态更新时间（时间戳）
    @ExcelProperty(index = 2)
    private String upTime;
    // 激活日期（格式为 yyyy-MM-dd）
    @ExcelProperty(index = 3)
    private String initDate;

    @ExcelProperty(index = 4)
    // 传感器状态：1 在线、2 停车离线、 0 异常离线
    private Integer sensorStatus;

    public SFPushStatus() {
    }


    public SFPushStatus(String sensorNo, String carrierNo, String upTime, String initDate, Integer sensorStatus) {
        this.sensorNo = sensorNo;
        this.carrierNo = carrierNo;
        this.upTime = upTime;
        this.initDate = initDate;
        this.sensorStatus = sensorStatus;
    }

    // Getter 和 Setter 方法
    public String getSensorNo() {
        return sensorNo;
    }

    public void setSensorNo(String sensorNo) {
        this.sensorNo = sensorNo;
    }

    public String getCarrierNo() {
        return carrierNo;
    }

    public void setCarrierNo(String carrierNo) {
        this.carrierNo = carrierNo;
    }

    public Integer getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(Integer sensorStatus) {
        this.sensorStatus = sensorStatus;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    @Override
    public String toString() {
        return "PushStatusSF{" +
                "sensorNo='" + sensorNo + '\'' +
                ", carrierNo='" + carrierNo + '\'' +
                ", sensorStatus=" + sensorStatus +
                ", upTime='" + upTime + '\'' +
                ", initDate='" + initDate + '\'' +
                '}';
    }
}
