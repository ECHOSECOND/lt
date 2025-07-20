package qita_.gaopinti;

import common.ListNode;

public class Kgeyizu_fanzhuan_lianbiao {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        // 1.计算链表长度
        int len = getLen(head);

        // 上一组的尾
        // 第一次为空只是赋值。 之后 prevTail.next=prev
        ListNode prevTail = null;
        ListNode newHead = null;

        ListNode cur = head;

        //2. 每k个一组
        for (int i = 0; i < len / k; i++) {

            // 这三个是翻转链表必须的
            ListNode next;
            ListNode pre = null; // 一、除了cur！！注意要写在一轮k翻转的内层 不然 下一轮的头节点.next=prev
            // 下一轮的头节点 如 3.next=2 ；3同时会作为3、4的尾节点 其next 指向5、6的头节点；相当于3的next重置了！
            // 5的next指向4；如果 5、6后面没有了，那么有环了 链表
            //  所以 prev每一轮翻转要重置为null

            // 每一轮翻转前记录cur 未来作为尾部 拼接下一轮
            // cur当前链表翻转的尾
            // 二、关键点，prevTailTmp先保存cur 后面 prevTail 再用它。表明这一轮的头节点，后面更新为prevTail 为下一轮服务
            ListNode prevTailTmp = cur;
            // k个一组翻转
            for (int j = 0; j < k; j++) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            // prev反转后链表的头
            if (newHead == null) {
                newHead = pre;
            }

            // 1、2第一轮翻转完 prevTail =null 无需设置，接着prevTail=1；等待 3、4翻转完后，1.next=4；接着 prevTail=3
            if (prevTail != null) {
                // 先用后更新
                prevTail.next = pre;
            }

            prevTail = prevTailTmp;

        }
        if (cur != null) {
            prevTail.next = cur;
        }
        return newHead;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {
        Kgeyizu_fanzhuan_lianbiao gg = new Kgeyizu_fanzhuan_lianbiao();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ListNode newHead = gg.reverseKGroup(head, 2);

        ListNode newCur = newHead;
        while (newCur != null) {
            System.out.println(newCur.val);
            newCur = newCur.next;
        }

    }

}
