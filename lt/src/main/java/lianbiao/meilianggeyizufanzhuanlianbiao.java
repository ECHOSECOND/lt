package lianbiao;

import common.ListNode;

public class meilianggeyizufanzhuanlianbiao {
    public ListNode swapPairs(ListNode head) {
        // 每两个一组反转链表
        int len = getLen(head);
        if (len<2){
            return head;
        }

        // 1. 与每k个一组翻转比较， k=2 即可

        int loop = len / 2;
        ListNode prevZu = null;
        ListNode cur = head;
        ListNode newHead = null;
        for (int i = 0; i < loop; i++) {
            // 每2个一组反转
            ListNode prev = null; // 指向反转后的头节点
            ListNode next;
            // 每一组的头 将作为上一组的链接点与本组的prev链接
            ListNode now = cur;
            for (int j = 0; j < 2; j++) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            // 第一组链表的头就是 新链表的头
            if (newHead == null) {
                newHead = prev;
            }
            // 先用 再更新prevZu 这样用的是上一组的！
            // 第一次用可能为null
            // prevZu是上一组反转后链表的尾
            if (prevZu != null) {
                prevZu.next = prev;
            }
            prevZu = now;
        }
        if (prevZu != null) {
            prevZu.next = cur;
        }
        return newHead;
    }

    public int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
