package com.woozhijun.interview.algo.link;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhijunwoo
 * @create by 2023/5/24 10:10
 * @Desc 实现LRU缓存， （哈希表 + 双向链表）
 */
public class LRUCache {
    private int size;
    private int capacity;
    private DLinkedNode head, tail;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     *
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            // 若链表超过最大容量，删除双向列表的尾部节点
            if (size > capacity) {
                DLinkedNode res = tail.prev;
                removeNode(res);
                cache.remove(res.key);
                --size;
            } else {
                // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
                node.value = value;
                moveToHead(node);
            }
        }
    }


    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
}

class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
    public DLinkedNode() {}
    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
