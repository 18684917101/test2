package com.zto;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import java.util.Arrays;

/**
 * 绑定主机
 */
public class ZT001 {
    public static void main(String[] args) {
        System.out.println(Validator.isEmpty("111"));
        String key="dcdz2taxCsbB67OyWy9o";
        String icode="ZT001";
        //解绑
        //String data ="{\"deviceId\":\"869786066442181\",\"licensePlate\":\"川B11111\",\"operationTime\":\"2023/10/10 15:16\",\"operationType\":\"1\"}";
        //绑定
        String data ="{\n" +
                "    \"pageNum\":1,\"pageSize\":10\n" +
                "}";
        String secret="4EQi16puvxBwsEcpQwnFvSpvnpcz24UJ";
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
