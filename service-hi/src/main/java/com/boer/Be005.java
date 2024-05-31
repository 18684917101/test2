package com.boer;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import java.util.Arrays;

/**
 * 接收传感器消息
 */
public class Be005 {
    public static void main(String[] args) {
        String key="dcdzyFwiLhZKqA89jvPP";
        String icode="BE005";
        String data ="[\n" +
                "    {\n" +
                "        \"Sensors\":\n" +
                "        [\n" +
                "            {\n" +
                "                \"ID\": \"96B703FE\",\n" +
                "                \"Press\": 10.1,\n" +
                "                \"temp\": 47,\n" +
                "                \"Pow\": 2.2,\n" +
                "                \"Pos\": \"1\",\n" +
                "                \"Stat\": \"160\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"ID\": \"96B71D79\",\n" +
                "                \"Press\": 11.1,\n" +
                "                \"temp\": 41,\n" +
                "                \"Pow\": 2.2,\n" +
                "                \"Pos\": \"2\",\n" +
                "                \"Stat\": \"160\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"ID\": \"68CE161C\",\n" +
                "                \"Press\": 10.2,\n" +
                "                \"temp\": 46,\n" +
                "                \"Pow\": 2.2,\n" +
                "                \"Pos\": \"4\",\n" +
                "                \"Stat\": \"160\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"ID\": \"96B70523\",\n" +
                "                \"Press\": 10.7,\n" +
                "                \"temp\": 44,\n" +
                "                \"Pow\": 2.2,\n" +
                "                \"Pos\": \"6\",\n" +
                "                \"Stat\": \"160\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"ID\": \"96B72668\",\n" +
                "                \"Press\": 11.3,\n" +
                "                \"temp\": 48,\n" +
                "                \"Pow\": 2.2,\n" +
                "                \"Pos\": \"7\",\n" +
                "                \"Stat\": \"160\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"ID\": \"971D6FB0\",\n" +
                "                \"Press\": 10.9,\n" +
                "                \"temp\": 40,\n" +
                "                \"Pow\": 2.2,\n" +
                "                \"Pos\": \"9\",\n" +
                "                \"Stat\": \"160\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"ID\": \"64CF3257\",\n" +
                "                \"Press\": 11.2,\n" +
                "                \"temp\": 32,\n" +
                "                \"Pow\": 2.2,\n" +
                "                \"Pos\": \"10\",\n" +
                "                \"Stat\": \"160\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"ID\": \"A8CE0FB6\",\n" +
                "                \"Press\": 10,\n" +
                "                \"temp\": 45,\n" +
                "                \"Pow\": 2.2,\n" +
                "                \"Pos\": \"11\",\n" +
                "                \"Stat\": \"160\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"ID\": \"74CE0F1D\",\n" +
                "                \"Press\": 9.9,\n" +
                "                \"temp\": 47,\n" +
                "                \"Pow\": 2.2,\n" +
                "                \"Pos\": \"12\",\n" +
                "                \"Stat\": \"160\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"SN\": \"868366075983789\",\n" +
                "        \"Plate\": \"浙ANF76挂\",\n" +
                "        \"Type\": 3,\n" +
                "        \"Time\": \"2024-05-22 17:12:38\",\n" +
                "        \"Lat\": 43.945956,\n" +
                "        \"Lng\": 87.523749\n" +
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
        String response = HttpUtil.post("https://sh.sy.tehst.56luntai.com:18886//dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
//        String response = HttpUtil.post("127.0.0.1:8080/dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
//        String response = HttpUtil.post("http://www.56dache.com/dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
        System.out.println(response);
    }
}
