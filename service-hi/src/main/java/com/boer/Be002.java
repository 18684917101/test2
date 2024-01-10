package com.boer;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import java.util.Arrays;

/**
 * 传感器绑定接口
 */
public class Be002 {
    public static void main(String[] args) {
        String key="dcdzyFwiLhZKqA89jvPP";
        String icode="BE002";
        //解绑
//        String data ="{\n" +
//                "  \"deviceId\": \"869786066442181\",\n" +
//                "  \"licensePlate\": \"川B11111\",\n" +
//                "  \"operationTime\": \"2023/10/19 13:12\",\n" +
//                "  \"tyreLocationInfo\": \"[{\\\"sensorId\\\":\\\"\\\",\\\"tyreLocationId\\\":1}]\"\n" +
//                "}";
        //绑定
        String data ="{\n" +
                "  \"deviceId\": \"869786067774392\",\n" +
                "  \"licensePlate\": \"川B11111\",\n" +
                "  \"operationTime\": \"2023/10/19 13:12\",\n" +
                "  \"tyreLocationInfo\": \"[{\\\"sensorId\\\":\\\"81243469\\\",\\\"tyreLocationId\\\":1}]\"\n" +
                "}";
        String secret="AtXCbBLmcN4hGWOYX4dgPGnIPyUOTe3e";
        String nonce =  "11231231";
        JSONObject dataBody = new JSONObject();
        dataBody.put("key", key);
        dataBody.put("secret", secret);
        String timeStamp = String.valueOf(System.currentTimeMillis());
        dataBody.put("ts", timeStamp);
        dataBody.put("icode", icode);
        dataBody.put("dataBody", data);
        dataBody.put("nonce", nonce);
        String[] validateArray = new String[] { key, timeStamp, data, nonce};
        Arrays.sort(validateArray);
        String digestHex = SecureUtil.hmacSha1(secret).digestHex(ArrayUtil.join(validateArray, ""));
        dataBody.put("sig", digestHex);
        System.out.println(dataBody);
        String response = HttpUtil.post("http://sh.sy.tehst.56luntai.com//dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
//        String response = HttpUtil.post("127.0.0.1:8080/dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
//        String response = HttpUtil.post("http://www.56dache.com/dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
        System.out.println(response);
    }
}
