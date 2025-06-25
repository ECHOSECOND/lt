package lianbiao;

import common.ListNode;

public class huanxinglianbiao {
    public boolean hasCycle(ListNode head) {
        // 1.使用快慢指针 一开始快慢指针都指向head
        ListNode fast = head;
        ListNode slow = head;

        // 2. while 判断条件为 slow和fast fast.next不为空
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
