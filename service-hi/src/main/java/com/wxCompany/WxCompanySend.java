package com.wxCompany;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
public class WxCompanySend {
    /**
     * 测试企业微信通知.
     */
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();

        //标题
        String title ="测试任务"+"的任务审批提醒 ";
        //接受人 一般是名字驼峰
        String touser ="HuangChaoFan";
        //跳转描述
        String btntxt="详情测试";
        //跳转链接
        String url ="https://sh.sy.tehst.56luntai.com/dache-project/#/project/task";
        String accessToken = "kjS0dd7rBZ0OyQinsLBxUVhrm-jIhFMcYbKsBjcBDV617QUQZHV3OQLTinJaQQ13UUuq9ze_v1HclqDSc-fGDN6cBk7wInvmdh9NMUzFyp-JyckjrPZFOrkX5YWHxC5nbwQ5GbOK4XQSClnk0JNSsAqzDwrX8Tp3k04GEwOWavMeuZKr5gRx52EZzrbfnZMwhEadWuJOOz2SKbxwiCgNSw";
        //消息内容
        String text = "<div class=\"highlight\">"
                + DateUtil.today()
                + "</div>"
                + "<div class=\"normal\">"
                + "huangchaofanTest" +
                "</div>";

        map.put("touser", touser);
        map.put("agentid", "1000074");
        map.put("msgtype", "textcard");

        Map<String, Object> subMap = new HashMap<String, Object>();

        subMap.put("title", title);
        subMap.put("description", text);
        subMap.put("url", url);
        subMap.put("btntxt", btntxt);

        map.put("textcard", subMap);

 
        log.info("messageSendUrl:{}, accessToken:{}, 参数:{}, ", "https://qyapi.weixin.qq.com/cgi-bin/message/send", "", JSON.toJSONString(map));

        HttpRequest httpRequest = (new HttpRequest("https://qyapi.weixin.qq.com/cgi-bin/message/send"
                + "?access_token="
                + accessToken)).method(Method.POST);
        String resultStr = httpRequest.body(JSON.toJSONString(map)).execute().body();

        log.info("发送消息返回结果 resultStr:{},", JSON.toJSONString(resultStr));

        String s = CurlConverter.convertToCurl(httpRequest,JSON.toJSONString(map));
        log.info(s);
        JSONObject result = JSON.parseObject(resultStr);

        if (0 != result.getIntValue("errcode")) {

            throw new ValidateException(result.getString("errmsg"));

        }
    }



//
//    private static final String FORMAT_HEADER = "-H \"%1$s:%2$s\"";
//    private static final String FORMAT_METHOD = "-X %1$s";
//    private static final String FORMAT_BODY = "-d '%1$s'";
//    private static final String FORMAT_URL = "\"%1$s\"";
//    private static final String CONTENT_TYPE = "Content-Type";
//
//    /**
//     * <p>
//     * HttpServletRequest 转化为 CURL 命令
//     * </p>
//     *
//     * @param request request
//     * @return String
//     * @author Tophua
//     * @since 2021/8/19
//     */
//    public String getCurl(HttpServletRequest request) {
//        String curl;
//        try {
//            List<String> parts = new ArrayList<>();
//            parts.add("curl");
//            String url = request.getRequestURL().toString();
//            String method = request.getMethod();
//            String contentType = request.getContentType();
//            String queryString = request.getQueryString();
//            parts.add(String.format(FORMAT_METHOD, method.toUpperCase()));
//
//            Map<String, String> headers = new HashMap<>(16);
//            Enumeration<String> headerNames = request.getHeaderNames();
//            while (headerNames.hasMoreElements()) {
//                String key = headerNames.nextElement();
//                headers.put(key, request.getHeader(key));
//            }
//            headers.forEach((k, v) -> parts.add(String.format(FORMAT_HEADER, k, v)));
//            if (StrUtil.isNotEmpty(contentType) && !headers.containsKey(CONTENT_TYPE)) {
//                parts.add(String.format(FORMAT_HEADER, CONTENT_TYPE, contentType));
//            }
//            if (StrUtil.isNotEmpty(queryString)) {
//                url = HttpUtil.urlWithForm(url, queryString, CharsetUtil.CHARSET_UTF_8, false);
//            }
//            if (ContentType.isFormUrlEncode(contentType) && CollUtil.isNotEmpty(request.getParameterMap())) {
//                request.getParameterMap().forEach((k, v) ->
//                        parts.add(StrUtil.format("--data-urlencode '{}={}'", k, ArrayUtil.get(v, 0))));
//            }
//            if (StrUtil.startWithIgnoreCase(contentType, ContentType.JSON.toString())) {
//                BodyReaderHttpServletRequestWrapper wrapper = (BodyReaderHttpServletRequestWrapper) request;
//                String body = StrUtil.utf8Str(wrapper.getCachedBody());
//                if (StrUtil.isNotEmpty(body)) {
//                    parts.add(String.format(FORMAT_BODY, body));
//                }
//            }
//            parts.add(String.format(FORMAT_URL, url));
//            curl = StrUtil.join(" ", parts);
//        } catch (Exception e) {
//            e.printStackTrace();
//            curl = null;
//        }
//        return curl;
//    }

}
