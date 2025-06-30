package lianbiao;

import common.ListNode;

public class kgeyizufanzhuanlianbiao {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 每两个一组反转链表
        int len = getLen(head);
        // 4. 边界条件处理！！
        if (len<k){
            return head;
        }
        int loop = len / k;
        ListNode prevZuTail = null;
        ListNode cur = head;
        ListNode newHead = null;
        for (int i = 0; i < loop; i++) {

            // 3. 只是涉及到当前组反转的可以 在这里局部变量存储！！像 prevZuTail、cur 跨组的声明为全局的！！！

            // 每2个一组反转
            ListNode prev = null; // 指向反转后的头节点
            ListNode next;
            // 每一组的头 将作为上一组的链接点与本组的prev链接
            ListNode now = cur;

            // 1.1 翻转一部分（k个）节点 就是 从 0开始到k 遍历k次 进行翻转操作

            // 2.1 值的注意的是 要将cur 也就是当前组的第一个节点 记录下来。未来作为这一组的尾节点，供下一组实验。本组的尾节点指向下一组的head节点

            for (int j = 0; j < k; j++) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            // 3. 第一组链表的头就是 新链表的头

            // 3.1 单独处理头节点

            if (newHead == null) {
                newHead = prev;
            }
            // 先用 再更新prevZu 这样用的是上一组的！
            // 1. prevZuTail是上一组反转后链表的尾.使用一个指针记录 上一组的尾  也就是反转前的 cur（反转前用变量保存下！！！）！！！ 第一次用可能为null

            // 4.1 上一组的尾节点的next指向本组的头节点 prev

            // 5.1 本身链表翻转是不需要借助 dummyNode 的

            if (prevZuTail != null) {
                prevZuTail.next = prev;
            }

            // 6.1 上一组的尾节点 为 一开始遍历的cur节点 用now保存下来了
            prevZuTail = now;
        }

        // 2. 由于每k个一组，可能会剩余不足k。剩余的也要用 prevZuTail 来链接下！！！！

        // 6.2 注意有可能不是k的整数，但是我们只处理了 n/k 轮。 此时cur是剩余部分的头节点，上一组的尾节点 指向cur即可。
        if (prevZuTail != null) {
            prevZuTail.next = cur;
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

    public static ListNode reverseKGroup2(ListNode head, int k) {
        // 1.分组
        int len = getLen2(head);
        ListNode cur = head;
        ListNode newHead = null;
        ListNode lastFirst = null;
        ListNode prev = null;
        int zuNum = len / k;
        for (int i = 0; i < zuNum; i++) {
            // 从 i*k开始，反转 一开始[0,k)
            //            ListNode kHead = reverseK(cur, i * k, k);
            // 反转 i 到 i+k之间的链表 cur相当于链表的头节点
            // head相当于cur 从cur开始反转
            ListNode next = null;
            ListNode kFirst = cur;
            for (int j = 0; j < k && cur != null; j++) {
                // 要修改next需要先保存
                next = cur.next;
                cur.next = prev;
                prev = cur; // 3. prev一定指向链表反转后的第一个节点！！！！lastFirst是链表反转前的第一个节点！！！cur指向链表反转后的下一个节点，如果单链表反转就是null！
                cur = next;
            }
            // 1. 先使用后重置 就是上一次的！！！ 先保存当轮的初始值，先用。然后用完后重置为本轮的！ 这样 就是本轮 用了上轮的值！！！
            if (lastFirst != null) {
                lastFirst.next = prev;
            }
            lastFirst = kFirst;
            // prev为反转后链表的头节点
            // 经过 k 个节点的反转后， 操作了 k个节点，但是 cur已经指向 第k+1个节点 即第二段链表的头节点了。
            // prev为 一段段反转后的链表头节点 即 1，3中的 3；5，7中的 7；需要上一段链表的头节点 1【刚开始遍历的顺序】.next指向本段反转后的头节点即prev
            if (i == 0) {
                newHead = prev;
            }
        }
        if (lastFirst != null) {
            lastFirst.next = cur;
        }
        return newHead;
    }

    private static int getLen2(ListNode head) {
        int count = 0;
        // 为了不破坏head 避免head指向最后一个节点
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

}
