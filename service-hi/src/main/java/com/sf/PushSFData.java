package com.sf;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PushSFData {

    public static void main(String[] args) throws Exception {
        List<List<ThirdpartTempAlarmDto>> allList = new ArrayList<>();
        List<ThirdpartTempAlarmDto> list1 = new ArrayList<>();
        ThirdpartTempAlarmDto dto = new ThirdpartTempAlarmDto();
        dto.setCarrierNo("粤B00001");
        dto.setSensorNo("G30222100");
        dto.setAlarmType("1");
        dto.setGpsLat(113.15425);
        dto.setGpsLng(23.3545);
        list1.add(dto);
        allList.add(list1);
        List<ThirdpartTempAlarmDto> list2 = new ArrayList<>();
        ThirdpartTempAlarmDto dto2 = new ThirdpartTempAlarmDto();
        dto2.setCarrierNo("粤B00002");
        dto2.setSensorNo("G30222102");
        dto2.setAlarmType("1");
        dto2.setGpsLat(113.15425);
        dto2.setGpsLng(23.3545);
        list2.add(dto2);
        ThirdpartTempAlarmDto dto3 = new ThirdpartTempAlarmDto();
        dto3.setCarrierNo("粤B00002");
        dto3.setSensorNo("G30222102");
        dto3.setAlarmType("1");
        dto3.setGpsLat(113.15425);
        dto3.setGpsLng(23.3545);
        list2.add(dto3);
        allList.add(list2);

        Date now = new Date();
        long timestamp = now.getTime();
        String appSecret = "1pJkS09dNn6tt";
        Map<String, Object> paramsHeader = Maps.newHashMap();
        paramsHeader.put("appid", "DCDZ");
        paramsHeader.put("timestamp",timestamp+"");
        String sign = Md5SignUtil.signRequest(paramsHeader,appSecret);
        paramsHeader.put("sign",sign);

        String res = OkHttpClient.syncPostHeader("https://gis-rss-scm-stsoc.sit.sf-express.com:48020/stsoc/openapi/pushAlarm",paramsHeader, JSONObject.toJSONString(allList));
    }




}
