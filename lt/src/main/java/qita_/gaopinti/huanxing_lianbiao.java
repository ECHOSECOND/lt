package qita_.gaopinti;

import common.ListNode;

public class huanxing_lianbiao {
    public ListNode detectCycle(ListNode head) {

        // 1.定义快慢指针 都初始化为head
        ListNode slow = head;
        ListNode fast = head;

        ListNode meetNode = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 说明遇到了有环 记得要退出！！！不然有环的链表无限循环！！！
                meetNode = slow;
                break;
            }
        }

        // 2. 一个从相遇点 一个从起点

        ListNode cur = head;
        while (cur != null && meetNode != null) {
            if (cur == meetNode) {
                return meetNode;
            }
            cur = cur.next;
            meetNode = meetNode.next;
        }

        // 这里打印环形链表的环的长度

        // 3. 计算环长度 只要current遍历的链表与cur环入口节点相同就是 环长度计算完了。
        int cycleLength = 1;
        ListNode current = cur.next;
        while (current != cur) {
            cycleLength++;
            current = current.next;
        }

        System.out.println("环长度: " + cycleLength);
        return null;

    }
}
