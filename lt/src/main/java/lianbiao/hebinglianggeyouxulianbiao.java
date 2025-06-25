package lianbiao;

import common.ListNode;

public class hebinglianggeyouxulianbiao {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 可以定义一个虚拟指针，最终返回head.next即可、这是 创建一个链表的常用技巧

        // 1. 一般定义一个虚拟指针 最终用于返回 .next 为新链表的head

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }

        // 2. 首先是两个链表都不为空 取小的。 如果某个为空了，那个不为空，next指向哪个链表

        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        // 1. 先同时遍历两个链表 同时存在进行新链表的组装
        ListNode head = new ListNode(-1);
        ListNode cur = head; // 用一个变量定义当前节点 随时变化 保护原head节点
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1!=null){
            cur.next = list1;
        }
        if(list2!=null){
            cur.next = list2;
        }
        return head.next;
    }

}
