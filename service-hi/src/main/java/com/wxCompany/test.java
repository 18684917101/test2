package com.wxCompany;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class test {
    /**
     * 测试企业微信通知.
     */
    public static void main(String[] args) {
        System.out.println(desensitizedName("黄超凡"));
    }

    public static String desensitizedName(String fullName){
        if (!StrUtil.isBlank(fullName)) {
            String name = StrUtil.sub(fullName, 0,1);
            return name +"师傅";
        }
        return fullName;
    }
}
