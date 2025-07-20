package qita_.gaopinti;

import common.ListNode;

public class shanchu_daoshu_k_ge_jiedian {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1.涉及到删除节点 有可能是删除head节点 所以我们定义虚拟节点

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode cur = dummyNode;

        // 2. 一个指针先走k步

        ListNode fast = cur;
        ListNode slow = cur;

        for (int i = 0; i < n; i++) {
            if(fast!=null) {
                fast = fast.next;
            }
        }
        if(fast==null) {
            return dummyNode.next;
        }

        // 3. 快慢一起走 当fast=null
        ListNode pre = dummyNode;
        while (fast != null && slow != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return dummyNode.next;
    }
}
