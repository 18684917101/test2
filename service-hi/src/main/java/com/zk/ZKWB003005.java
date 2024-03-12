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
        //测试
       // String appSecret = "EdjZVkpbM3Q6K4Gs8MWqBSrDfLhcJM23";
        //生产
        String appSecret = "9RHKme8b2QyeC8EYMgB5N5PKwhE7cabk";


        //String data ="{\"reportName\":\"杨福霞\",\"orderId\":\"ORDER1705281927146185\",\"businessNature\":\"维修\",\"repairPosition\":\"HEAD\",\"carTrailerId\":\"浙H99789\",\"app_key\":\"KKCX\",\"servicerName\":\"卡客畅行（浙江）\",\"servicerSiteName\":\"卡客伴驰（德坤广州驻场）服务站\",\"totalCost\":\"0.00\",\"mileage\":\"25\",\"timestamp\":\"2024-01-22 10:06:29\"}";

        String data ="{\"app_key\":\"KKCX\",\"businessNature\":\"保养\",\"carTrailerId\":\"浙H3112挂\",\"details\":[{\"cost\":\"2.00\",\"materials\":[{\"detail\":\"测试\",\"detail_cost\":\"1.00\",\"hour_cost\":\"1.00\"},{\"detail\":\"测试\",\"detail_cost\":\"1.00\",\"number\":\"1.00\",\"sum_cost\":\"1.00\",\"unit_price\":\"1.00\"}],\"serviceContent\":\"测试\"}],\"orderId\":\"ORDER1706524254969237\",\"repairPosition\":\"HANGING\",\"reportName\":\"桑\",\"servicerName\":\"卡客畅行（浙江）信息技术有限公司\",\"servicerSiteName\":\"全国\",\"sign\":\"2E25E02D5C659F3BE7D8CB2FD42DE7D4\",\"timestamp\":\"2024-01-29 18:32:43\",\"totalCost\":\"2.00\"}";

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
