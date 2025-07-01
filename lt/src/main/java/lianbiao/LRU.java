package lianbiao;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    private int capacity;
    // 1. get、put 以 O1 时间复杂度 说明需要 map


    // 2. 最近最少使用 有个时间的概念 最近用链表来存储 时间先后。最近使用的要放到链表的头。
    // 这样容量不足时的删除就可以删除链表尾部的节点了。尾部的节点就是最近不怎么访问的。

    private Map<Integer, Node> dataMap;
    private Node head;
    private Node tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        dataMap = new HashMap<>();
    }

    public void put(int key, int value) {
        // 判断key是否存在
        if (dataMap.containsKey(key)) {
            Node node = dataMap.get(key);
            node.val = value;

            // 3. 移动到头部 需要先删除原节点的关系 然后把节点移动到头部。

            // 移动到头部，对于已经出现的节点 一定要处理好原关系！！！
            delNodeRelation(node);
            // 将节点移动到头部
            moveNodeToHead(node);
            return;
        }
        if (dataMap.size() >= capacity) {
            // 删除最旧的节点
            delOldNode();
        }
        Node node = new Node(key, value);
        dataMap.put(key, node);
        moveNodeToHead(node);
    }

    int get(int key) {
        Node node = dataMap.get(key);
        if (node == null) {
            return -1;
        }
        delNodeRelation(node);
        // 将node移动到tail 同时删除当前链表关系
        moveNodeToHead(node);
        return node.val;
    }

    private void delNodeRelation(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveNodeToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private void delOldNode() {
        Node old = tail.prev;
        if (old == head) {
            return;
        }
        // 4. 删除节点关系 再清除map的节点
        delNodeRelation(old);
        dataMap.remove(old.key);
    }

    class Node {
        private int key;
        private int val;
        private Node next;
        private Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
