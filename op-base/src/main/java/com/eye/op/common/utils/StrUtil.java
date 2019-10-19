package com.eye.op.common.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StrUtil extends StringUtils{
	public static boolean isEquals(String str1,String str2){
		if(str1==null&&str2==null){
			return true;
		}
		if(str1==null||str2==null){
			return false;
		}
		return (str1.trim()).equalsIgnoreCase(str2.trim());
		
	}
	public static boolean isNotEquals(String str1,String str2){
		if(isEquals(str1,str2)){
			return false;
		}
		return true;
	}
	// 判断一个字符串是否含有数字
    public static boolean hasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }
    public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}
}
