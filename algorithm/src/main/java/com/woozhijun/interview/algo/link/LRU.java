package com.woozhijun.interview.algo.link;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhijunwoo
 * @create by 2023/05/16 5:41 PM
 * @Desc
 */
public class LRU<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE;

    public LRU(int cacheSize) {
        // true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当 map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
        return size() > CACHE_SIZE;
    }

    public static void main(String[] args) {
        System.out.println((1>>>4));
    }
}
