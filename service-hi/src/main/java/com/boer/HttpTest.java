package com.boer;

import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hcf
 * @create 2023/9/27 上午10:21
 */
public class HttpTest {

    private static String boerHost ="https://tapi-test.e5ex.cn";
    private static String key ="367527c47c69d29f";

    private static String secret ="B9630d805bb1d054902eb326cb842052";

    static String receiveUrlDevice = "/export/product/6044";

    static String receiveUrlSensor = "/export/sensor/6044";


    public static void main(String[] args) {
        String data ="{\"actionType\":1,\"deviceId\":\"869786066442181\",\"itemsPerPage\":10,\"licensePlate\":\"浙H23788\",\"manufacturerId\":\"5\",\"pageNum\":1,\"tyreLocationInfo\":[{\"attachment\":[],\"id\":76902276,\"tyreLocation\":1,\"tyreLocationId\":1},{\"attachment\":[],\"id\":76902277,\"tyreLocation\":2,\"tyreLocationId\":2},{\"attachment\":[],\"id\":76902278,\"tyreLocation\":3,\"tyreLocationId\":3},{\"attachment\":[],\"id\":76902279,\"tyreLocation\":4,\"tyreLocationId\":4},{\"attachment\":[],\"id\":76902280,\"tyreLocation\":5,\"tyreLocationId\":5},{\"attachment\":[],\"id\":76902281,\"tyreLocation\":6,\"tyreLocationId\":6},{\"attachment\":[],\"id\":76902282,\"tyreLocation\":98,\"tyreLocationId\":98},{\"attachment\":[],\"id\":76902283,\"tyreLocation\":99,\"tyreLocationId\":99}]}";
        DeviceBindSensorVm vm = JSON.parseObject(data, DeviceBindSensorVm.class);
        pushBoerSensor(vm);
    }

    /**
     * 推送传感器绑定信息
     * @param deviceBindSensorParam
     */
    public static Map<String, Object> pushBoerSensor(DeviceBindSensorVm deviceBindSensorParam){
        StringBuilder url = new StringBuilder();
        url.append(boerHost).append(receiveUrlSensor);
        try {
            //将对象中的轮位设备集合，转换为Map集合
            List<Map<String, Object>> mapList = deviceBindSensorParam.getTyreLocationInfo().stream()
                    .map(param -> {
                        Map<String, Object> map = new HashMap<>();
                        map.put("sensorId", param.getSensorId());
                        map.put("tyreLocationId", param.getTyreLocationId());
                        return map;
                    })
                    .collect(Collectors.toList());
            //这里只是为了取参数名 为后面排序 然后再遍历取参数值拼成字符串
            LinkedHashMap<String, Object> databody = new LinkedHashMap<>();
            databody.put("deviceId", deviceBindSensorParam.getDeviceId());
            databody.put("licensePlate", deviceBindSensorParam.getLicensePlate());
            databody.put("tyreLocationInfo", mapList);
            System.out.println("推送博尔设备传感器绑定信息入参："+databody+", URL："+url);
            String response = boerPost(databody, url.toString());
            System.out.println("推送博尔传感器绑定信息请求返回："+response);
            JSONObject jsonObject = JSON.parseObject(response);
            int code = Integer.parseInt(jsonObject.getString("code"));
            String msg = jsonObject.getString("msg");
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",code);
            map.put("msg",msg);
            return map;
        }catch (Exception e){
            System.out.println("推送博尔绑定传感器异常："+ e);
            throw new ValidateException("推送博尔绑定传感器异常");
        }
    }

    private static String boerPost(LinkedHashMap<String, Object> map,String url){
        long l = System.currentTimeMillis() / 1000;
        List<String> list = new ArrayList<>();
        map.forEach(((o, o2) -> {
            list.add(o);
        }));
        String body = JSONObject.toJSONString(map);
        /*  时时秒级时间戳   */
        String timestamp = String.valueOf(l);
        /*  随机字符串   */
        String nonce = "a785f9487f8ee3c8755f";

        //所有一级参数字段名 排序
        Object[] objects = list.toArray();
        Arrays.sort(objects);
        //按规则组合成字符串
        ArrayList<String> object = new ArrayList<>();
        for (Object s : objects) {
            object.add(String.format("%s=%s&", s, map.get(s + "")));
        }
        //这里的排序不能变
        object.add("key=" + key);
        object.add("timestamp=" + timestamp);
        object.add("random=" + nonce);

        String digestHex = SecureUtil.hmacSha1(secret).digestHex(ArrayUtil.join(object.toArray(), ""));

        return HttpRequest.post(url).
                header("Content-Type", "application/json").
                header("random", nonce).
                header("signature", digestHex).
                header("timestamp", timestamp)
                .body(body).execute().body();
    }
}
