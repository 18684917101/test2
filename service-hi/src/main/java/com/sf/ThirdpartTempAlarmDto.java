package com.sf;

import lombok.Data;

@Data
public class ThirdpartTempAlarmDto {
    private String carrierNo;//StringY车牌号，如“川A7029挂”
    private String wheelPosition;//StringY轮位位置 如 L2- 2轴左，R2-2轴右
    private String sensorNo;//StringY传感器号，如“G8223500”，自行定义
    private String sensorStatus;//IntegerY传感器状态，1 在线、2 停车离线、 0 异常离线
    private String tempTime;//StringY传感器最后更新时间 时间戳
    private String createTime;//StringY数据推送时间 时间戳
    private String gpsTime;//StringY⻋辆定位时间 时间戳
    private String altitude;//IntegerN海拔 ，如25
    private String temp;//IntegerY轴温℃，如“130”
    private String envTemp;//IntegerN环境温度℃，如“21”
    private Double gpsLat;//DoubleY纬度
    private Double gpsLng;//DoubleY经度
    private Double speed;//DoubleY车速 km/h，如“60”
    private Integer carrierType;//IntegerY⻋辆类型 Integer 3:卡/货⻋ 4:挂⻋ 5:牵引⻋
    private String alarmType;//StringY告警类型：1-高危告警 2-解除高危告警




}