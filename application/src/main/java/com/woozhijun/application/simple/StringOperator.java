package com.woozhijun.application.simple;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;

/**
 * @Author: wuzhijun
 * @Date: 2020/10/18 21:17
 */
public class StringOperator {

    public static int parserStringToInt(String str) throws Exception {
        if (StringUtils.isBlank(str)) {
            return 0;
        }
        str = str.trim();
        str = str.replace("+", "");
        int symbol = 1;
        if (str.indexOf("-") == 0) {
            str = str.replace("-", "");
            symbol = -1;
        }
        if (str.indexOf(".") == 0 || str.indexOf(".") == str.length() - 1) {
            return 0;
        }
        byte[] bytes = str.getBytes();
        int num = 0;
        for (int i = bytes.length - 1; i >= 0; i--) {
            if (bytes[i] == '.' && (bytes[i + 1] >= '0' && bytes[i + 1] <= '9') && (bytes[i - 1] >= '0' && bytes[i - 1] <= '9')) {
                continue;
            } else if (bytes[i] < '0' || bytes[i] > '9') {
                return 0;
            } else {
                num += (bytes[i] - '0') * Math.pow(10, bytes.length - 1 - i);
            }
        }
        return num * symbol;
    }

    public static void main(String[] args) {
        try {
            System.out.println(parserStringToInt("10"));
            System.out.println(parserStringToInt("-1"));
            System.out.println(parserStringToInt("123123123123123"));
            System.out.println(parserStringToInt("-354353453453453 "));
            System.out.println(parserStringToInt("1.0"));
            System.out.println(parserStringToInt("1.023"));
            System.out.println(parserStringToInt("123213dasda12"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}