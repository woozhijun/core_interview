package com.woozhijun.interview.algo.string;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单词替换
 * @author zhijunwoo
 * @create by 2023/5/9 20:23
 * @Desc
 */
@Slf4j
@Data
public class ReplaceWords {

    public static String solution1(List<String> dict, String sentence) {

        Trie trie = new Trie();
        dict.forEach(out -> {
            Trie cur = trie;
            for (int i = 0; i < out.length(); i++) {
                char c = out.charAt(i);
                cur.children.putIfAbsent(c, new Trie());
                cur = cur.children.get(c);
            }
            cur.children.put('#', new Trie());
        });
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = findRoot(words[i], trie);
        }
        return String.join(" ",  words);
    }

    public static String findRoot(String word, Trie trie) {
        StringBuilder sb = new StringBuilder();
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#')) {
                return sb.toString();
            }
            if (!cur.children.containsKey(c)) {
                return word;
            }
            sb.append(c);
            cur = cur.children.get(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> dicts = List.of("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";


        List<String> dicts2 = List.of("a","b","c");
        String sentence2 = "aadsfasf absbs bbab cadsfafs";

        System.out.println(solution1(dicts, sentence));
        System.out.println(solution1(dicts2, sentence2));
    }
}

class Trie {
    Map<Character, Trie> children;
    public Trie() {
        children = new HashMap<>();
    }
}
