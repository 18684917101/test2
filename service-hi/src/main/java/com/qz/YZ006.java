package com.qz;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import java.util.Arrays;

/**
 * 胎温胎压
 */
public class YZ006 {
    public static void main(String[] args) {
        //test
//        String key="dcdzA5ZEMQuzNnM9m4r0";
//        String secret="cpwwBOm5dOXUCFN8iq1YgrLxRmD9PxC3";

        //pro
        String key="dcdzHTEcT4TQyn0mho6s";
        String secret="n5HTJnLPaZrPqu26tcTGZXyKDJVqWiOE";
        String icode="YZ006";
        //解绑
        //String data ="{\"deviceId\":\"869786066442181\",\"licensePlate\":\"川B11111\",\"operationTime\":\"2023/10/10 15:16\",\"operationType\":\"1\"}";
        //绑定
        String data ="[{\n" +
                "    \"Sensors\": [{\n" +
                "        \"ID\": \"22B012F31101\",\n" +
                "        \"Press\": 256,\n" +
                "        \"temp\": 70,\n" +
                "        \"Pow\": 2.2,\n" +
                "        \"Pos\": \"1\",\n" +
                "        \"Stat\": \"160\"\n" +
                "    }],\n" +
                "    \"SN\": \"22B012F311\",\n" +
                "    \"Plate\": \"豫A11111\",\n" +
                "    \"Type\": 4,\n" +
                "    \"Time\": \"2024-03-11 14:41:55\",\n" +
                "    \"Lat\": 25.853714,\n" +
                "    \"Lng\": 109.841412\n" +
                "}]";
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
//      String response = HttpUtil.post("http://sh.sy.tehst.56luntai.com//dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
//        String response = HttpUtil.post("127.0.0.1:8080/dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
        String response = HttpUtil.post("http://www.56dache.com/dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
        System.out.println(response);
    }
}
