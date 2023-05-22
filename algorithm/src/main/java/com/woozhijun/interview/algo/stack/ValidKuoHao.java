package com.woozhijun.interview.algo.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 验证有效括号
 * @Author: wuzhijun
 * @Date: 2021/11/15 13:07
 */
public class ValidKuoHao {

    private static final Map<Character, Character> map = new HashMap<>();

    static {
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
    }

    public boolean isValid(String s) {
        if (s.length() <= 0 || s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stk = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stk.push(c);
            } else {
                if (stk.isEmpty()) { return false; }
                if (map.containsValue(c)) {
                    Character v = map.get(stk.peek());
                    if (v != null && v.equals(c)) {
                        stk.pop();
                    }
                }
            }
        }
        return stk.isEmpty();
    }
}
