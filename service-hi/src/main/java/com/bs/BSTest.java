package com.bs;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import java.util.Arrays;

/**
 * 巴蜀推送轴温
 */
public class BSTest {
    public static void main(String[] args) {
        String request ="{\"carrierNo\":\"沪J1565挂\",\"carrierType\":4,\"gpsLat\":0.0,\"gpsLng\":0.0,\"positionTime\":\"2024-01-09 22:04:22\",\"secret\":\"9c80d85568c495ff1710ac58037a3277\",\"sensorNo\":\"G9675200\",\"speed\":0.0,\"temp\":16,\"timeStamp\":\"2024-01-09 22:04:22\"}";
        String url ="https://home.bs-56.com/tms-api/dache/trailer/receive";
        String response = HttpUtil.post(url, request, 5000);
        System.out.println(response);
    }
}
