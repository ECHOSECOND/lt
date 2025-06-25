package lianbiao;

import common.ListNode;

public class shanchulianbiaodaoshuNjiedian {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 1. 涉及到链表的新建、删除 都需要用 虚拟节点，删除需要设置 虚拟节点的next 为head

        ListNode tmpNode = new ListNode(-1);
        tmpNode.next = head;
        ListNode slow = tmpNode;
        ListNode fast = tmpNode;
        int step = 1;
        while (step <= n && fast != null) {
            fast = fast.next;
            step++;
        }
        if (fast == null) {
            return null;
        }
        // 快慢指针一起走

        // 2. 删除链表节点 需要定义 prev保留上一个节点。 prev一开始为slow节点，slow节点移动了 prev在下一轮才更新
        // 这样结束循环后，prev指向的是slow的上一个节点。 可以用prev来删除。
        // 极端情况下 倒数第n个节点是head节点，此时 prev=slow=dummyNode虚拟节点 用虚拟节点删除head节点
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        // slow节点就是倒数第k个节点
        prev.next = slow.next;
        return tmpNode.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findNode(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    public ListNode findNode(ListNode head, int n) {
        // 保留原head节点
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i=0;i<n && p1!=null;i++){
            p1 = p1.next;
        }
        // 两个指针一起走
        while(p1!=null && p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
