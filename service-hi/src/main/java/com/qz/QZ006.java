package com.qz;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import java.util.Arrays;

/**
 * 绑定主机
 */
public class QZ006 {
    public static void main(String[] args) {
        System.out.println(Validator.isEmpty("111"));
        String key="dcdzA5ZEMQuzNnM9m4r0";
        String icode="QZ006";
        //解绑
        //String data ="{\"deviceId\":\"869786066442181\",\"licensePlate\":\"川B11111\",\"operationTime\":\"2023/10/10 15:16\",\"operationType\":\"1\"}";
        //绑定
        String data ="[{\"Sensors\":[{\"ID\":\"A8D41112\",\"Press\":11.1,\"temp\":70,\"Pow\":2.2,\"Pos\":\"1\",\"Stat\":\"160\"},{\"ID\":\"58D4109A\",\"Press\":11.7,\"temp\":51,\"Pow\":2.2,\"Pos\":\"2\",\"Stat\":\"160\"},{\"ID\":\"81244749\",\"Press\":10.5,\"temp\":51,\"Pow\":2.2,\"Pos\":\"3\",\"Stat\":\"160\"},{\"ID\":\"8AD352A2\",\"Press\":10.8,\"temp\":54,\"Pow\":2.2,\"Pos\":\"4\",\"Stat\":\"160\"},{\"ID\":\"58D4070E\",\"Press\":10.4,\"temp\":56,\"Pow\":2.2,\"Pos\":\"5\",\"Stat\":\"160\"},{\"ID\":\"4AD41963\",\"Press\":10.7,\"temp\":61,\"Pow\":2.2,\"Pos\":\"6\",\"Stat\":\"160\"}],\"SN\":\"864383065908019\",\"Plate\":\"赣A68037\",\"Type\":4,\"Time\":\"2024-03-11 14:41:55\",\"Lat\":25.853714,\"Lng\":109.841412}]";
        String secret="cpwwBOm5dOXUCFN8iq1YgrLxRmD9PxC3";
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
//        String response = HttpUtil.post("http://sh.sy.tehst.56luntai.com//dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
        String response = HttpUtil.post("127.0.0.1:8080/dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
//        String response = HttpUtil.post("http://www.56dache.com/dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
        System.out.println(response);
    }
}
