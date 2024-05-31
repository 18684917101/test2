package com.qz;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import java.util.Arrays;

/**
 * 定位数据
 */
public class YZ010 {
    public static void main(String[] args) {
        String icode="YZ010";
        //test
        String key="dcdzA5ZEMQuzNnM9m4r0";
        String secret="cpwwBOm5dOXUCFN8iq1YgrLxRmD9PxC3";

        //pro
//        String key="dcdzHTEcT4TQyn0mho6s";
//        String secret="n5HTJnLPaZrPqu26tcTGZXyKDJVqWiOE";
     //绑定
        String data ="{\n" +

                "  \"screenId\": \"4453\",\n" +
                "  \"licensePlate\": \"粤BMB457\",\n" +
                "  \"trailerLicensePlate\": \"粤BKP04挂\",\n" +
                "  \"changeTime\": \"2024-05-30 11:16:51\"\n" +

                "}";
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
