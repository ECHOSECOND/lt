package qita_.gaopinti;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    // 给出存储结构map 以及 节点node，注意写内部类 写一下构造函数
    private Map<Integer, Node> map;
    // 给出链表定义
    private Node head;
    private Node tail;

    /*
    实现lru的 get、put能力
     */

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 将node移动到head下
        delNodeRelation(node);
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private void delNodeRelation(Node node) {
        // 注意双向链表 要同时操作 next和prev
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        //  更新
        if (node != null) {
            node.value = value;
            map.put(key, node);
            delNodeRelation(node);
            moveToHead(node);
            return;
        }
        // 新增
        int capacityNow = map.size(); // 注意map本身就有size方法！计算ma元素个数！
        if (capacityNow >= capacity) {
            // 先删除
            delOldNode();
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        moveToHead(newNode);

    }

    private void delOldNode() {
        Node oldNode = tail.prev;
        oldNode.prev.next = oldNode.next;
        oldNode.next.prev = oldNode.prev;
        map.remove(oldNode.key);
    }

    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node prev = null;
        Node next = null;
    }

}
