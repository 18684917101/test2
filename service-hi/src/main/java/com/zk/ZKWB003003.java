package com.zk;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.zk.vo.MaintenanceWorkAudit;
import com.zk.vo.ZkMaintenanceEntity;

import java.util.Arrays;
import java.util.Collections;

/**
 * 众卡维保审核
 */
public class ZKWB003003 {
    public static void main(String[] args) {
        String data="{\n" +
                "    \"app_key\": \"KKCX\",\n" +
                "    \"timestamp\": \"2020-09-24 09:07:50\",\n" +
                "    \"orderId\": \"ORDER1703835128613092\",\n" +
                "    \"auditResult\": \"通过\",\n" +
                "    \"auditRemark\": \"驳回备注2\"\n" +
                "}";

        String timeStamp = "1806002988494";
//        String timeStamp = String.valueOf(System.currentTimeMillis());

        String nonce =  "11231231";
        String secret="KIQINqwvNiWiM62R5xcD9qrW7ZC1gdWL";
        //测试
        String zkSecret="EdjZVkpbM3Q6K4Gs8MWqBSrDfLhcJM23";
        //生产
//        String zkSecret = "9RHKme8b2QyeC8EYMgB5N5PKwhE7cabk";
        ZkMaintenanceEntity dataBody = JSON.parseObject(data, ZkMaintenanceEntity.class);
        dataBody.setSign( SignUtil.getSignByMd5ToUpperCase(ZkMaintenanceEntity.class,dataBody,zkSecret,true));

//        String url ="127.0.0.1:8080/dache-wmms-admin/api/common/if?icode=ZKWB003&key=dcdz3e344lq4Kd6ScAjU&ts=" + timeStamp + "&nonce=" + nonce;
        String url ="https://sh.sy.tehst.56luntai.com:18886/dache-wmms-admin/api/common/if?icode=ZKWB003&key=dcdz3e344lq4Kd6ScAjU&ts=" + timeStamp + "&nonce=" + nonce;
        System.out.println(dataBody);
        HttpRequest request = HttpRequest.post(url)
                .header("Content-Type", "application/json")  // 设置请求头为 application/json
                .body(JSON.toJSONString(dataBody))
                .timeout(5000);
        // 执行请求
        HttpResponse response = request.execute();

        // 获取响应结果
        String result = response.body();
        System.out.println(result);
    }
}
