package lianbiao;

import common.ListNode;

public class huiwenlianbiao {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            // 思路：链表反转一次 判断原链表和反转后的链表是否完全相同

            // 1. 注意链表翻转 是原地翻转，会改变head指针的。
            // 所以这里先复制下原链表

            ListNode headB = fuZhiOld(head);

            // 翻转链表 原地
            ListNode headA = reverseList(head);

            // 2. 比较原链表和翻转后的链表  逐个看 节点的 val是不是相同

            while (headA != null && headB != null) {
                // 注意反转后的链表节点具柄不相同了！val相同！
                if (headA.val != headB.val) {
                    return false;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return true;
        }

        private ListNode fuZhiOld(ListNode head) {
            ListNode newHead = null;
            ListNode newHeadCur = null;
            ListNode cur = head;
            while (cur != null) {
                if (newHead == null) {
                    newHead = new ListNode(cur.val);
                    // 注意确定head 后 要用cur 来承接一下！！
                    newHeadCur = newHead;
                } else {
                    // 完整复制 是new ListNode
                    newHeadCur.next = new ListNode(cur.val);
                    newHeadCur = newHeadCur.next;
                }
                cur = cur.next;
            }
            return newHead;
        }

        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;
            ListNode next = null;
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
}
