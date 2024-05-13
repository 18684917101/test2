package com.sf;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.sf.entity.SFPushStatus;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PushSFStatusData {

    public static void main(String[] args) throws Exception {

        // 创建一个输入流，将 Excel 文件读取出来
        InputStream inputStream = new FileInputStream("C:\\Users\\hcf\\Desktop\\pushSF0513.xlsx");

        List<SFPushStatus> tmpList = EasyExcel.read(inputStream)
                // 设置与Excel表映射的类
                .head(SFPushStatus.class)
                // 设置sheet,默认读取第一个
                .sheet()
                // 设置标题所在行数
                .headRowNumber(1)
                // 异步读取
                .doReadSync();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        // 按carrierNo字段分组，并将分组结果转换为列表
        List<List<SFPushStatus>> groupedList = tmpList.stream()
                .collect(Collectors.groupingBy(SFPushStatus::getCarrierNo))
                .values()
                .stream()
                .map(group -> group.stream()
                        .map(status -> {
                            // 将initDate转换为LocalDate对象
                            LocalDate initDate = LocalDate.parse(status.getInitDate(), dateTimeFormatter);
                            // 将upTime转换为时间戳
                            LocalDateTime upTime = LocalDateTime.parse(status.getUpTime(), dateTimeFormatter);
                            long timestamp = upTime.toInstant(ZoneOffset.UTC).toEpochMilli() / 1000;
                            return new SFPushStatus(status.getSensorNo(), status.getCarrierNo(), String.valueOf(timestamp), initDate.format(dateFormatter),status.getSensorStatus() == 0?1:0);
                        })
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());




        Date now = new Date();
        long timestamp = now.getTime();
        //test
        String appSecret = "1pJkS09dNn6tt";
        String url ="https://gis-rss-scm-stsoc.sit.sf-express.com:48020/stsoc";

        //pro
//        String appSecret = "opW79kLM78Sp";
//        String url ="https://gis-rss-scm-stsoc.sf-express.com/stsoc";
        Map<String, Object> paramsHeader = Maps.newHashMap();
        paramsHeader.put("appid", "DCDZ");
        paramsHeader.put("timestamp",timestamp+"");
        String sign = Md5SignUtil.signRequest(paramsHeader,appSecret);
        paramsHeader.put("sign",sign);

        String res = OkHttpClient.syncPostHeader(url+"/openapi/pushStatus",paramsHeader, JSONObject.toJSONString(groupedList));
    //    System.out.println(res);
    }




}
