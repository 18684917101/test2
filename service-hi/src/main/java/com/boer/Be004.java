package com.boer;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import java.util.Arrays;

/**
 * 接收主机定位消息
 */
public class Be004 {
    public static void main(String[] args) {
        String key="dcdzyFwiLhZKqA89jvPP";
        String icode="BE004";
        String data ="[\n" +
                "    {\n" +
                "        \"Pow\": 4.215,\n" +
                "        \"Ps\": 1,\n" +
                "        \"GSM\": 0,\n" +
                "        \"GPS\": 0,\n" +
                "        \"SN\": \"864383060262299\",\n" +
                "        \"Plate\": \"冀RK7957\",\n" +
                "        \"Type\": 4,\n" +
                "        \"envTemp\": 8,\n" +
                "        \"altitude\": 9,\n" +
                "        \"Time\": \"2024-03-11 13:50:59\",\n" +
                "        \"Lat\": 119.247663,\n" +
                "        \"Lng\": 141.928381,\n" +
                "        \"Speed\": 1,\n" +
                "        \"Dir\": 0\n" +
                "    }\n" +
                "]";
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
//        String response = HttpUtil.post("https://sh.sy.tehst.56luntai.com:18886//dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
        String response = HttpUtil.post("127.0.0.1:8080/dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
//        String response = HttpUtil.post("http://www.56dache.com/dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
        System.out.println(response);
    }
}
