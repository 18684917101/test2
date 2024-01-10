package com.zk;

import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boer.DeviceBindSensorVm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hcf
 * @create 2023/9/27 上午10:21
 */
public class HttpPushBegin {

    private static String boerHost ="https://tapi-test.e5ex.cn";
    private static String key ="367527c47c69d29f";

    private static String secret ="B9630d805bb1d054902eb326cb842052";

    static String receiveUrlDevice = "/export/product/6044";

    static String receiveUrlSensor = "/export/sensor/6044";


    public static void main(String[] args) {

    }


    private<T>  JSONObject signByClass(JSONObject data,Class<T> classData) {
        T tyreInspect = JSONObject.parseObject(JSONObject.toJSONString(data), classData);
        JSONObject dataBody = new JSONObject();
        dataBody.put("key", key);
        dataBody.put("secret", secret);
        String timeStamp = String.valueOf(new Date().getTime());
        dataBody.put("timeStamp", timeStamp);
        dataBody.put("data", tyreInspect);
        String[] validateArray = new String[] { key, timeStamp, JSON.toJSONString(tyreInspect) };
        Arrays.sort(validateArray);
        String digestHex = SecureUtil.hmacSha1(secret).digestHex(ArrayUtil.join(validateArray, ""));
        dataBody.put("sign", digestHex);
        return dataBody;
    }
}
