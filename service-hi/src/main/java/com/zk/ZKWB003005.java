package com.zk;

import com.alibaba.fastjson.JSON;
import com.zk.vo.MaintenanceWorkOrderToZk;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

import static cn.hutool.core.util.NumberUtil.add;

/**
 * 众卡维保生成签名
 */
public class ZKWB003005 {

    public static final String RECEIVE_INFO_URL ="http://122.144.220.210:50119/tms/interface/api/maintain/receiveInfo";

    public static void main(String[] args) {

        BigDecimal total = BigDecimal.ZERO;

        System.out.println(addTest(total).toString());
        System.out.println(total);
        String key="KKCX";
        //测试  972418FF94FD9E9B19B7E970C1CDF9AD
       // String appSecret = "EdjZVkpbM3Q6K4Gs8MWqBSrDfLhcJM23";
        //生产
        String appSecret = "9RHKme8b2QyeC8EYMgB5N5PKwhE7cabk";


        //String data ="{\"reportName\":\"杨福霞\",\"orderId\":\"ORDER1705281927146185\",\"businessNature\":\"维修\",\"repairPosition\":\"HEAD\",\"carTrailerId\":\"浙H99789\",\"app_key\":\"KKCX\",\"servicerName\":\"卡客畅行（浙江）\",\"servicerSiteName\":\"卡客伴驰（德坤广州驻场）服务站\",\"totalCost\":\"0.00\",\"mileage\":\"25\",\"timestamp\":\"2024-01-22 10:06:29\"}";

       // String data ="{\"app_key\":\"KKCX\",\"businessNature\":\"保养\",\"carTrailerId\":\"浙H3112挂\",\"details\":[{\"cost\":\"2.00\",\"materials\":[{\"detail\":\"测试\",\"detail_cost\":\"1.00\",\"hour_cost\":\"1.00\"},{\"detail\":\"测试\",\"detail_cost\":\"1.00\",\"number\":\"1.00\",\"sum_cost\":\"1.00\",\"unit_price\":\"1.00\"}],\"serviceContent\":\"测试\"}],\"orderId\":\"ORDER1706524254969237\",\"repairPosition\":\"HANGING\",\"reportName\":\"桑\",\"servicerName\":\"卡客畅行（浙江）信息技术有限公司\",\"servicerSiteName\":\"全国\",\"sign\":\"2E25E02D5C659F3BE7D8CB2FD42DE7D4\",\"timestamp\":\"2024-01-29 18:32:43\",\"totalCost\":\"2.00\"}";

        String data ="{\n" +
                "    \"reportName\": \"\",\n" +
                "    \"orderId\": \"ORDER1711171368727994\",\n" +
                "    \"sign\": \"972418FF94FD9E9B19B7E970C1CDF9AD\",\n" +
                "    \"businessNature\": \"保养\",\n" +
                "    \"repairPosition\": \"HANGING\",\n" +
                "    \"carTrailerId\": \"浙H8607挂\",\n" +
                "    \"app_key\": \"KKCX\",\n" +
                "    \"servicerName\": \"卡客畅行（浙江）信息技术有限公司\",\n" +
                "    \"servicerSiteName\": \"全国\",\n" +
                "    \"details\":\n" +
                "    [\n" +
                "        {\n" +
                "            \"serviceContent\": \"安能BPW400K 3轴挂车保养包\",\n" +
                "            \"cost\": \"660.00\",\n" +
                "            \"materials\":\n" +
                "            [\n" +
                "                {\n" +
                "                    \"number\": \"6.00\",\n" +
                "                    \"sum_cost\": \"120.00\",\n" +
                "                    \"detail\": \"清洗轴承\",\n" +
                "                    \"unit_price\": \"20.00\",\n" +
                "                    \"detail_cost\": \"120.00\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"number\": \"6.00\",\n" +
                "                    \"sum_cost\": \"120.00\",\n" +
                "                    \"detail\": \"涂抹润滑脂\",\n" +
                "                    \"unit_price\": \"20.00\",\n" +
                "                    \"detail_cost\": \"120.00\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"number\": \"6.00\",\n" +
                "                    \"sum_cost\": \"60.00\",\n" +
                "                    \"detail\": \"安装车轴\",\n" +
                "                    \"unit_price\": \"10.00\",\n" +
                "                    \"detail_cost\": \"60.00\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"afterPhotos\":\n" +
                "            [\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=b2452e42793cc38f78cf3124635de61a&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=0618cd6062cc34b3e5572b9213406c39&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=683e1552a800a1a576299d5b36c3daf8&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=862caabb09833d6a4a71d37bf7e83068&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=6a3d0c06e773ec2f6ec87816fe28b08b&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=782035ab6f0b8848772f1cc6c7f5eafe&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=43dfbf3c48de6103deee92f7d2a99ccf&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=06eb852b303543a9e1c19924c35ce0c2&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=5a2bc8562f45af62a633e4e0af869e96&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=b6059ef6391303d8b898de56991a8f2c&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=20c674ddadd7371b54b885dd21ada4a8&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=f8c038b0070af1965ee853e4d5ca2cb1&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=0d5403854d2b71965d2d22746fe34241&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=36edd67150321015d58742df3263468e&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=bee821e12b1baf9f2b7abe55dfa77f64&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=13275033717b3b7a12a1aedaafc9818a&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=6bf9671f703eed3f840f517be55bfb51&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=a231da6e5c572a1debb6015f33a7968c&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=7de7e28b50833019ddadef2cca0d1f7f&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=501bdaa7ab1b4a166f195e00cd18311c&suffix=jpeg\"\n" +
                "            ],\n" +
                "            \"beforePhotos\":\n" +
                "            [\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=b2452e42793cc38f78cf3124635de61a&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=0618cd6062cc34b3e5572b9213406c39&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=683e1552a800a1a576299d5b36c3daf8&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=862caabb09833d6a4a71d37bf7e83068&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=6a3d0c06e773ec2f6ec87816fe28b08b&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=782035ab6f0b8848772f1cc6c7f5eafe&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=43dfbf3c48de6103deee92f7d2a99ccf&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=06eb852b303543a9e1c19924c35ce0c2&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=5a2bc8562f45af62a633e4e0af869e96&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=b6059ef6391303d8b898de56991a8f2c&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=20c674ddadd7371b54b885dd21ada4a8&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=f8c038b0070af1965ee853e4d5ca2cb1&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=0d5403854d2b71965d2d22746fe34241&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=36edd67150321015d58742df3263468e&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=bee821e12b1baf9f2b7abe55dfa77f64&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=13275033717b3b7a12a1aedaafc9818a&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=6bf9671f703eed3f840f517be55bfb51&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=a231da6e5c572a1debb6015f33a7968c&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=7de7e28b50833019ddadef2cca0d1f7f&suffix=jpeg\",\n" +
                "                \"https://56dache.com/dache-wmms-admin/handler/multimedia/download.retrieve?hashcode=501bdaa7ab1b4a166f195e00cd18311c&suffix=jpeg\"\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"totalCost\": \"660.00\",\n" +
                "    \"timestamp\": \"2024-05-13 15:41:35\"\n" +
                "}";
        Map<String, Object> resultMap = JSON.parseObject(data, Map.class);
        MaintenanceWorkOrderToZk orderToZk = JSON.parseObject(data, MaintenanceWorkOrderToZk.class);
     //   System.out.println("签名1:  "+getSign(resultMap));
        System.out.println("签名2:  "+SignUtil.getSignByMd5ToUpperCase(MaintenanceWorkOrderToZk.class,orderToZk,appSecret,true));
        orderToZk.setSign(SignUtil.getSignByMd5ToUpperCase(MaintenanceWorkOrderToZk.class,orderToZk,appSecret,true));
        System.out.println(JSON.toJSONString(orderToZk));

    }

    private static BigDecimal addTest(BigDecimal total) {
        return total.add(new BigDecimal(59));

    }


    public static String getSign(Map map) {

        // 组合签名
        String appSecret = "EdjZVkpbM3Q6K4Gs8MWqBSrDfLhcJM23";
        try {
            List<Map.Entry<String, String>> infos = new ArrayList<Map.Entry<String, String>>(map.entrySet());
            // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
            Collections.sort(infos, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return (o1.getKey()).compareTo(o2.getKey());
                }
            });
            // 构造签名键值对的格式
            StringBuilder strBu = new StringBuilder();
            for (Map.Entry<String, String> item : infos) {
                if (!StringUtils.isEmpty(item.getKey())) {
                    String key = item.getKey();
                    Object val = item.getValue();
                    if (val != null) {
                        strBu.append(key + "=" + val + "&");
                    }
                }
            }
            strBu.append("app_secret=" + appSecret);
            System.out.println(strBu.toString());

            return DigestUtils.md5Hex(strBu.toString()).toUpperCase();
        } catch (Exception e) {
            return null;
        }

    }
}
