package lianbiao;

import common.ListNode;

public class paixulianbiao {
    // 1. 这里是 归并的思想
    public ListNode sortList(ListNode head) {
        // 归并思想一样 也是递归。主函数 写好递归结构 归并的也是区间 找中间节点
        return mergeSortListNode(head);
    }

    private ListNode mergeSortListNode(ListNode head) {
        // 找到链表的中间节点


        // 1. 递归结束条件 head ==null 或者 head没有子节点 也就是只有节点本身了 直接 return
        if (head == null || head.next == null) {
            return head;
        }
        // 注意链表有个特殊点： 拆分两段链表 其实用next就可以了。
        // 也就是找到链表的中点 mid， mid.next是下一段链表 起到了类似 left,mid-1 与 mid+1,right 的效果。
        // 找链表的中点 也不需要 left、right 两个参数了；使用 链表的head节点即可。

        // 2. 寻找链表的中点， 相当于 得到两部分。  注意两部分需要将 mid.next =null 置为null 才可以！

        ListNode mid = findMid(head);
        ListNode next = mid.next;
        // 注意这个操作很关键。因为 如果 链表就一个节点了，那么 findMid始终返回这一个节点。 需要将其next置为null，这样下次递归就结束了。
        mid.next = null;
        ListNode left = mergeSortListNode(head);
        ListNode right = mergeSortListNode(next);

        // 3. 最终变成对两个有序链表进行merge。

        // merge
        ListNode mergeHead = mergeTwoSortListNode(left, right);
        return mergeHead;
    }

    private ListNode mergeTwoSortListNode(ListNode left, ListNode right) {
        ListNode newHead = new ListNode(-1);
        // 创建新链表时 一定要用cur！
        ListNode newHeadCur = newHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                newHeadCur.next = new ListNode(left.val);
                left = left.next;
            } else {
                newHeadCur.next = new ListNode(right.val);
                right = right.next;
            }
            newHeadCur = newHeadCur.next;
        }
        if (left != null) {
            newHeadCur.next = left;
        }
        if (right != null) {
            newHeadCur.next = right;
        }
        return newHead.next;
    }

    // 快慢指针处理是否有环这种问题时，是可以 在slow和fast赋值后再判断 相当于先对slow和fast进行了一次赋值。 下一次进行判断。

    // 链表中点！！！！
    // 但是 快慢指针处理 链表中点，比如 对于 两个节点的链表， 中点应该是 第一个； 这样需要先进行判断 下面 fast.next不为null&&fast.next.next不为null

    // 4. 寻找链表中点 用快慢指针，快慢指针都是 初始化 slow和fast=head
    // 但是 快慢指针处理 链表中点，比如 对于 两个节点的链表， 中点应该是 第一个； 这样需要先进行判断 下面 fast.next不为null&&fast.next.next不为null
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
