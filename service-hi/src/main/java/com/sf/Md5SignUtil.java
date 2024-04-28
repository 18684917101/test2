package com.sf;

import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.google.common.hash.Hashing;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Md5SignUtil {

	public static String signRequest(Map<String, Object> params, String secret) throws IOException {
		// 第一步：检查参数是否已经排序
		String[] keys = params.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		// 第二步：把所有参数名和参数值串在一起
		StringBuffer query = new StringBuffer();
		query.append(secret);
		for (String key : keys) {
			Object o = params.get(key);
			if (o!= null && o!="") {
				query.append(key).append(o);
			}
		}
		query.append(secret);
//		logger.info("query={}",query);
		// 第三步：使用MD5加密
		byte[] bytes = encryptMD5(query.toString());
		// 第四步：把二进制转化为大写的十六进制(正确签名应该为32大写字符串，此方法需要时使用)
		return byte2hex(bytes);
	}
	public static byte[] encryptMD5(String data) throws IOException {
		return Hashing.md5().hashBytes(data.getBytes("utf-8")).asBytes();
	}

	public static byte[] encryptMD0(String data) {
		return DigestUtil.md5(StrUtil.utf8Bytes(data));
	}
	public static byte[] encryptMD51(String data) {
		return DigestUtil.md5(data,"utf-8");
	}
	public static byte[] encryptMD52(String data) {
		return DigestUtil.md5(StrUtil.utf8Bytes(data));
	}

	public static byte[] encryptMD53(String data) {
		return DigestUtil.md5(data.getBytes());
	}
	public static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toUpperCase());
		}
		return sign.toString();
	}
	@SneakyThrows
	public static void main(String[] args) {

		System.out.println(HexUtil.encodeHexStr(encryptMD5("test")));
		System.out.println(HexUtil.encodeHexStr((encryptMD0("test"))));
		System.out.println(HexUtil.encodeHexStr((encryptMD51("test"))));
		System.out.println(HexUtil.encodeHexStr((encryptMD52("test"))));
		System.out.println(HexUtil.encodeHexStr((encryptMD53("test"))));

	}
}	