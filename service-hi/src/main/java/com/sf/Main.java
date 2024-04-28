package com.sf;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("1".equals(1));
        // 假设这是你要上传的数据
        String data = "Your data to compress";

        // 使用 GZIPOutputStream 进行压缩
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
            gzipOutputStream.write(data.getBytes());
        }

        // 获取压缩后的 byte[] 数组
        byte[] compressedData = byteArrayOutputStream.toByteArray();

        // 输出压缩后的 byte[] 数组
        System.out.println("压缩后的数据长度：" + compressedData.length);
    }

    public static String sendGzipRequest(String urlStr, String dataList, Map<String, Object> paramsHeader) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Encoding", "gzip");
        connection.setRequestProperty("Content-Type", "application/json; charset=ISO-8859-1");
        connection.setRequestProperty("Accept-Charset", "ISO-8859-1");
        connection.setRequestProperty("contentType", "ISO-8859-1");
        connection.setRequestProperty("appid", (String)paramsHeader.get("appid"));
        connection.setRequestProperty("timestamp", (String)paramsHeader.get("timestamp"));
        connection.setRequestProperty("sign", (String)paramsHeader.get("sign"));

        String str = JSONObject.toJSONString(dataList);//对象转json串
        // 压缩数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream)) {
            gzipOutputStream.write(str.getBytes());
        }
        byte[] compressedBytes = byteArrayOutputStream.toByteArray();

        // 发送压缩后的数据
        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(compressedBytes);
        }
        // 接收响应
        int responseCode = connection.getResponseCode();
        StringBuilder response = new StringBuilder();
        InputStream inputStream = responseCode == 200 ? connection.getInputStream() : connection.getErrorStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        inputStream.close();
        System.out.println("response: " + response);
        // 关闭连接
        connection.disconnect();
        return response.toString();
    }
}
