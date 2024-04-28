package com.sf;

import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
@Slf4j
public class OkHttpClient {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private volatile static okhttp3.OkHttpClient client;

    private static final int MAX_IDLE_CONNECTION = 200;

    private static final long KEEP_ALIVE_DURATION = 5;

    private static final long CONNECT_TIMEOUT = 10;

    private static final long READ_TIMEOUT = 15;

    /**
     * 单例模式(双重检查模式) 获取类实例
     *
     * @return client
     */
    private static okhttp3.OkHttpClient getInstance() {
        if (client == null) {
            synchronized (okhttp3.OkHttpClient.class) {
                if (client == null) {
                    client = new okhttp3.OkHttpClient.Builder().connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                            .connectionPool(
                                    new ConnectionPool(MAX_IDLE_CONNECTION, KEEP_ALIVE_DURATION, TimeUnit.MINUTES))
                            .build();
                }
            }
        }
        return client;
    }

    public static String syncPostHeader(String url, Map<String, Object> params, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder();
        try {
            if (!CollectionUtils.isEmpty(params)) {
                final Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
                while (iterator.hasNext()) {
                    final Map.Entry<String, Object> entry = iterator.next();
                    builder.addHeader(entry.getKey(), (String) entry.getValue());
                }
            }
            builder.post(body);
            builder.url(url);
            Request request = builder.build();

            Response response = OkHttpClient.getInstance().newCall(request).execute();
            String result = response.body().string();

            log.info("syncPost url:{}, response = {}, responseBody= {}", url, response.code(), result.length());
            if (!response.isSuccessful()) {
                throw new IOException("三方接口返回http状态码为" + response.code());
            }
            return result;
        } catch (Exception e) {
            log.error("syncPostHeader remote interface url:{} have a ecxeption {}", url, e.getMessage());
            throw new RuntimeException("三方接口返回异常");
        }
    }

}