package com.wxCompany;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;


import java.util.HashMap;


public class CurlConverter {

    public static String convertToCurl(HttpRequest httpRequest, String jsonString) {
        StringBuilder curlCommand = new StringBuilder(StrUtil.LF);

        // 添加请求方法
        curlCommand.append("curl -X ").append(httpRequest.getMethod()).append(" ").append("\\").append(StrUtil.LF);
        curlCommand.append(httpRequest.getUrl()).append(" ").append("\\").append(StrUtil.LF);
        // 添加请求头
        curlCommand.append(" -H ").append("'Content-Type: application/json'").append(" ").append("\\").append(StrUtil.LF);

        HashMap<String, String> map = new HashMap<>();
        // 添加请求体
        if (jsonString != null) {
            curlCommand.append(" -d '").append(jsonString).append("'");
        }

        return curlCommand.toString();
    }


}
