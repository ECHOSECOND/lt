package qita_.gaopinti;

import common.ListNode;

public class lianbiao_paixu {
    public ListNode sortList(ListNode head) {
        // 我们采用归并排序的思想

        // 不断找mid节点，然后合并两个有序链表

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;

        // 递归找中节点
        ListNode firstSort = sortList(head);
        ListNode secondSort = sortList(next);

        return merge(firstSort,secondSort);

    }

    private ListNode merge(ListNode firstSort, ListNode secondSort) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (firstSort != null && secondSort != null) {
            if (firstSort.val < secondSort.val) {
                cur.next = firstSort;
                firstSort = firstSort.next;
            }else {
                cur.next = secondSort;
                secondSort = secondSort.next;
            }
            cur = cur.next;
        }
        if (firstSort != null) {
            cur.next = firstSort;
        }
        if (secondSort != null) {
            cur.next = secondSort;
        }
        return dummy.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        // 考虑到下面的边界 这里的 fast初始化为head.next
        ListNode fast = head.next;

        // 考虑边界 1 或者 1、2 这种情况

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
