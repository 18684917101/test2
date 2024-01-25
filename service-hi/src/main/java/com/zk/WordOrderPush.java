package com.zk;

import cn.hutool.core.lang.Validator;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

/**
 * 维保工单推送
 */
public class WordOrderPush {
    public static void main(String[] args) {
        System.out.println(Validator.isEmpty("111"));
//        String key="dcdz3e344lq4Kd6ScAjU";
//        String icode="ZKWB003";
        //解绑
        //String data ="{\"deviceId\":\"869786066442181\",\"licensePlate\":\"川B11111\",\"operationTime\":\"2023/10/10 15:16\",\"operationType\":\"1\"}";
        //绑定
        String data ="{\n" +
                "    \"app_key\": \"zk130ps216xx321xx\",\n" +
                "    \"timestamp\": \"2020-09-24 09:07:50\",\n" +
                "    \"sign\": \"DAD09B142C4177D792CC92B18EA35731\",\n" +
                "    \"orderId\": \"xxxx\",\n" +
                "    \"auditResult\": \"驳回\",\n" +
                "    \"auditRemark\": \"驳回备注\"\n" +
                "}";

//        String data ="{\"licensePlate\":\"川B11111\",\"driverName\":\"张7\",\"driverCellphone\":\"13766668077\",\"secondDriverName\":\"张一\",\"secondDriverCellphone\":\"1386666899\",\"departureTime\":\"2023-07-21 18:00\",\"arrivalTime\":\"2023-07-21 18:00\",\"departureAddress\":\"浙江省金华市金东区双尖大街506号\",\"departureLongitude\":\"121.207452\",\"departureLatitude\":\"121.207452\",\"arrivalAddress\":\"浙江省金华市金东区双尖大街506号\",\"arrivalLongitude\":\"121.207452\",\"arrivalLatitude\":\"121.207452\",\"truckRouteName\":\"成都-莆田\"}";

        String secret="KIQINqwvNiWiM62R5xcD9qrW7ZC1gdWL";
        String nonce =  "11231231";
        JSONObject dataBody = new JSONObject();
        dataBody.put("app_key", "dcdz3e344lq4Kd6ScAjU");
        dataBody.put("timestamp", "2020-09-24 09:07:50");
        dataBody.put("sign", "DAD09B142C4177D792CC92B18EA35731");
        dataBody.put("orderId", "xxx");
        dataBody.put("auditResult", "驳回");
        dataBody.put("auditRemark", "驳回");
//        dataBody.put("secret", secret);
        String timeStamp = String.valueOf(System.currentTimeMillis());
        dataBody.put("ts", timeStamp);
//        dataBody.put("icode", icode);
//        dataBody.put("dataBody", data);
        dataBody.put("nonce", nonce);
//        String[] validateArray = new String[] { key, timeStamp, data, nonce};
//        Arrays.sort(validateArray);
//        String digestHex = SecureUtil.hmacSha1(secret).digestHex(ArrayUtil.join(validateArray, ""));
//        dataBody.put("sig", digestHex);
        System.out.println(dataBody);
//        String response = HttpUtil.post("http://sh.sy.tehst.56luntai.com//dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
        String response = HttpUtil.post("127.0.0.1:8080/dache-wmms-admin/api/common/if?icode=ZKWB003&key=dcdz3e344lq4Kd6ScAjU&secret=KIQINqwvNiWiM62R5xcD9qrW7ZC1gdWL", dataBody.toString(), 5 * 1000);
//        String response = HttpUtil.post("http://www.56dache.com/dache-wmms-admin/api/common/if", dataBody.toString(), 5 * 1000);
        System.out.println(response);
    }
}
