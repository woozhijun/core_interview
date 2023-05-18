package com.woozhijun.interview.algo.string;

import org.apache.commons.lang3.StringUtils;

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

    /**
     * 字符串相加
     * @param n1
     * @param n2
     * @return
     */
    public String addString(String n1, String n2) {
        int i = n1.length() - 1, j = n2.length() - 1, add = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? n1.charAt(i) - '0' : 0;
            int y = j >= 0 ? n2.charAt(j) - '0' : 0;
            int result = x + y + add;
            sb.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        sb.reverse();
        return sb.toString();
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