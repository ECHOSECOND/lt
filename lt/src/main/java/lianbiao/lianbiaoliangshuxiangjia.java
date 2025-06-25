package lianbiao;

import common.ListNode;

public class lianbiaoliangshuxiangjia {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Cur = l1;
        ListNode l2Cur = l2;
        // 定义虚拟节点 准备构建链表

        // 1. 同样构建虚拟节点 准备新链表的创建 dummyNode

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int jinWeiVal = 0;

        // 2. 注意遍历条件是 其中一个不为空 都要计算。 这可与链表拼接不一样，一个为空了 不需要继续遍历了
        // 直接拼接上就行
        // 所以遍历条件是 1Cur != null || l2Cur != null

        while (l1Cur != null || l2Cur != null) {
            int sumVal = 0;
            if (l1Cur != null && l2Cur != null) {
                // 两者相加
                // 利用上次的结果 再更新
                sumVal = l1Cur.val + l2Cur.val + jinWeiVal;
                l1Cur = l1Cur.next;
                l2Cur = l2Cur.next;
            } else if (l1Cur != null) {
                sumVal = l1Cur.val + jinWeiVal;
                l1Cur = l1Cur.next;
            } else {
                sumVal = l2Cur.val + jinWeiVal;
                l2Cur = l2Cur.next;
            }
            cur.next = new ListNode(sumVal % 10); // 3. %10用来拼接链表节点 /10用来进位 用于下一次计算叠加。
            jinWeiVal = sumVal / 10;
            cur = cur.next;
        }
        // 4.有个容易出错的地方！如果最后一个进位不为0 要将其加到链表的尾
        if (jinWeiVal != 0) {
            cur.next = new ListNode(jinWeiVal);
        }
        return head.next;
    }
}
