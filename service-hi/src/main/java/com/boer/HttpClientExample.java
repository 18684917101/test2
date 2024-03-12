package com.boer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

public class HttpClientExample {

    public static void main(String[] args) {
        try {
            String apiUrl = "https://www.56dache.com/dache-wmms-admin/handler/authUserSignin/saveAuthUserSignin.message?whichMiniApp=wxe1a5f23b68e12a1e";

            // 构建请求体数据
            String requestBody = "{\"signinType\":-105,\"signinContent\":\"pages/index/index\",\"signinLongitude\":0,\"signinLatitude\":0}";

            // 第一次调用
            sendHttpRequest(apiUrl, requestBody, "7914f3d7-5e80-4fac-a11b-c3cc8ebdcfbd");


            // 第二次调用
            sendHttpRequest(apiUrl, requestBody, "7914f3d7-5e80-4fac-a11b-c3cc8ebdcfbd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendHttpRequest(String apiUrl, String requestBody, String token) {
        try {
            // 发送 HTTP POST 请求
            HttpResponse response = HttpRequest.post(apiUrl)
                    .header("Content-Type", "application/json; charset=UTF-8")
                    .header("token", token)
                    .body(requestBody)
                    .execute();

            // 获取响应状态码
            int responseCode = response.getStatus();
            System.out.println("Response Code: " + responseCode);

            // 获取响应内容
            String responseBody = response.body();
            System.out.println("Response Body: " + responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
