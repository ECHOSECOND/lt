package lianbiao;

import common.ListNode;

public class fanzhuanlianbiao {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        // 1. 因为要改变 curNode 的next 所以要先进行保存
        // 所以定义 next 指针用于保存

        // 2. prev 用于保存上一个指针 用完了 prev 再更新 赋值！！一开始初始化为 null！！

        // 3. cur是遍历指针，一开始指向head

        while (cur != null) {
            // 因为要改变cur.next 所以先用变量保存下
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // prev最终是新链表的头节点
        return prev;
    }
}
