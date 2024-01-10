package com.wxCompany;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class test {

    public static final String FRAGMENT_IDENTIFIER = "?{0}={1}";
    /**
     * 测试企业微信通知.
     */
    public static void main(String[] args) {
        String param = MessageFormat.format(FRAGMENT_IDENTIFIER, "taskId", "3423423");

       String url = "http://sh.sy.tehst.56luntai.com/dache-project/#/project/task";

        System.out.println(url+param);
    }

    public static String desensitizedName(String fullName){
        if (!StrUtil.isBlank(fullName)) {
            String name = StrUtil.sub(fullName, 0,1);
            return name +"师傅";
        }
        return fullName;
    }
}
