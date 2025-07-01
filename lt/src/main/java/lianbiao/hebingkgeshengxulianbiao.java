package lianbiao;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class hebingkgeshengxulianbiao {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            // 升序
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode head : lists) {
            if (head != null) {
                queue.add(head);
            }
        }

        ListNode tmp = new ListNode(-1);
        ListNode cur = tmp;

        // queue为空了，表明所有的head的next都遍历完了！
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            cur.next = new ListNode(minNode.val);
            cur = cur.next;
            if (minNode.next!=null){
                queue.add(minNode.next);
            }
        }
        return tmp.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        ListNode tmp = new ListNode(-1);
        ListNode cur = tmp;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        boolean hasHead = true;
        while (hasHead) {
            hasHead = false;

            for (int i = 0; i < lists.length; i++) {
                ListNode head = lists[i];
                if (head != null) {
                    queue.add(head.val);
                    hasHead = true;
                    ListNode next = head.next;
                    lists[i] = next;
                }
            }
        }
        while (!queue.isEmpty()) {
            cur.next = new ListNode(queue.poll());
            cur = cur.next;
        }
        return tmp.next;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length<=0){
            return null;
        }
        // 类似合并两个有序链表 要将多个链表中的最小值 取出来。 最小值可以用队列的方式
        // 队列升序 poll得到的是最小值
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        // 1. 默认升序， 也就是 poll 出来的时候 按照 从小到大的 顺序。
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a,b)->{
            return a.val-b.val;
        });

        // 2. 一开始 先将各个链表的header节点 放到队列。
        for(ListNode node: lists){
            if(node!=null){
                queue.add(node);
            }
        }

        // 从优先级队列取node
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            // 构建链表，cur.next 和 cur = cur.next 一定是一起出现的
            cur.next = new ListNode(node.val);
            cur = cur.next;
            if(node.next!=null){
                queue.add(node.next);
            }
        }
        return head.next;
    }

}
