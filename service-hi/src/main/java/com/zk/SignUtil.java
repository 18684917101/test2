package com.zk;

import cn.hutool.core.bean.BeanUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Sang
 * @create 2022/8/16 18:00
 */
@Slf4j
public class SignUtil {

    /**
     * 生成ascii排序并转为URL键值对的格式
     *
     * @param cls    实体类
     * @param date   对象
     * @param secret 加盐 密钥
     * @param <T>    T'
     * @return URL键值对字符串
     */
    public static <T> String getSignByAsciiAndSecret(Class<T> cls, Object date, String secret) {
        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
        TreeSet<String> hashSet = new TreeSet<>();
        Field[] fieldList = cls.getDeclaredFields();
        for (Field field : fieldList) {
            field.setAccessible(true);
            NotSign notSign = field.getAnnotation(NotSign.class);
            try {
                if (isFieldSign(date, field, notSign)) {
                    hashSet.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                log.error("生成签名错误：" + e.getMessage(), e);
            }
        }
        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
        Map<String, Object> map = BeanUtil.beanToMap(date);
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : hashSet) {
            stringBuilder.append(s).append("=").append(map.get(s)).append("&");
        }
        stringBuilder.append("app_secret=").append(secret);
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

    /**
     * 校验字段是否计入签名
     *
     * @param date    数据集
     * @param field   属性
     * @param notSign 注解
     * @return true -> 计入 false -> 不计入
     */
    private static boolean isFieldSign(Object date, Field field, NotSign notSign) throws IllegalAccessException {
        if (StringUtils.isEmpty(field.get(date))) {
            return false;
        }
        return notSign == null;
    }

    /**
     * 生成md5
     *
     * @param cls         实体类
     * @param date        对象
     * @param secret      加盐 密钥
     * @param isUpperCase 是否大写
     * @param <T>         T'
     */
    public static <T> String getSignByMd5ToUpperCase(Class<T> cls, Object date, String secret, boolean isUpperCase) {
        String md5Hex = DigestUtils.md5Hex(getSignByAsciiAndSecret(cls, date, secret));
        if (isUpperCase) {
            md5Hex = md5Hex.toUpperCase();
        }
        return md5Hex;
    }

    /**
     * 校验 sign
     *
     * @param cls         实体类
     * @param date        对象
     * @param secret      加盐 密钥
     * @param isUpperCase 是否大写
     * @param <T>         T'
     */
    public static <T> boolean verificationBySign(Class<T> cls, Object date, String secret, boolean isUpperCase,
                                                 String sign) {
        String md5Hex = DigestUtils.md5Hex(getSignByAsciiAndSecret(cls, date, secret));
        if (isUpperCase) {
            md5Hex = md5Hex.toUpperCase();
        }
        return md5Hex.equals(sign);
    }

    /**
     * 众卡签名认证
     *
     * @param zkMaintenanceEntity
     * true -> 签名未通过
     * false ->签名通过
     * @return
     */

}
