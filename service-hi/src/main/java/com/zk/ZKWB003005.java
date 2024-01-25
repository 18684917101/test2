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
        String appSecret = "EdjZVkpbM3Q6K4Gs8MWqBSrDfLhcJM23";

        //String data ="{\"reportName\":\"杨福霞\",\"orderId\":\"ORDER1705281927146185\",\"businessNature\":\"维修\",\"repairPosition\":\"HEAD\",\"carTrailerId\":\"浙H99789\",\"app_key\":\"KKCX\",\"servicerName\":\"卡客畅行（浙江）\",\"servicerSiteName\":\"卡客伴驰（德坤广州驻场）服务站\",\"totalCost\":\"0.00\",\"mileage\":\"25\",\"timestamp\":\"2024-01-22 10:06:29\"}";

        String data ="{\"reportName\":\"杨福霞\",\"orderId\":\"ORDER1705893617975567\",\"sign\":\"52FC99E4ABEF3C38AB3176D48848A89C\",\"businessNature\":\"保养\",\"remark\":\"备注蚊子\",\"repairPosition\":\"HEAD\",\"carTrailerId\":\"浙HC0319\",\"app_key\":\"KKCX\",\"servicerName\":\"卡客畅行（浙江）\",\"servicerSiteName\":\"卡客伴驰（德坤广州驻场）服务站\",\"details\":[{\"serviceContent\":\"工时1\",\"cost\":\"250.00\",\"materials\":[{\"number\":\"5.00\",\"hour_cost\":\"250.00\",\"sum_cost\":\"250.00\",\"detail\":\"配件1\",\"unit_price\":\"50.00\",\"detail_cost\":\"500.00\"}]}],\"totalCost\":\"0.00\",\"mileage\":\"20\",\"timestamp\":\"2024-01-22 11:24:56\"}";

        Map<String, Object> resultMap = JSON.parseObject(data, Map.class);
        MaintenanceWorkOrderToZk orderToZk = JSON.parseObject(data, MaintenanceWorkOrderToZk.class);
        System.out.println("签名1:  "+getSign(resultMap));
        System.out.println("签名2:  "+SignUtil.getSignByMd5ToUpperCase(MaintenanceWorkOrderToZk.class,orderToZk,appSecret,true));

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
