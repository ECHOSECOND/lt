package lianbiao;

import common.ListNode;

public class lianbiaoxiangjiao {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 两个没有环的链表
        // 1. 计算两个链表的长度， 让长的先走。 当两者长度一致时再开始一起走；如果链表的节点相同则认为是 相遇了。
        // 2. 通过方法计算链表长度。好处是：等同于 ListNode node = head 不会改变head！
        int len1 = getLen2(headA);
        int len2 = getLen2(headB);

        // 3. 定义从head开始的cur开始 行走！
        ListNode headACur = headA;
        ListNode headBCur = headB;

        if (len1 > len2) {
            // headA 先走
            int m = len1 - len2;
            int count = 1;
            while (headACur != null && count <= m) {
                headACur = headACur.next;
                count++;
            }
        } else {
            int m = len2 - len1;
            int count = 1;
            while (headBCur != null && count <= m) {
                headBCur = headBCur.next;
                count++;
            }
        }
        // 两个一起走 当相同时相遇
        while (headACur != null && headBCur != null) {
            if (headACur == headBCur) {
                return headACur;
            }
            headACur = headACur.next;
            headBCur = headBCur.next;
        }

        return null;
    }

    // 不会改变head
    public int getLen2(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }



    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 两个没有环的链表 如果只是判断是否有环 判断最后一个节点就可以
        // 这里是找相交节点
        // 得到链表长度 让长的链表先提前走，保证两个链表长度一样 再一起往下走

        int lenA = getLen(headA);
        int lenB = getLen(headB);
        if(lenA>lenB){
            int k = lenA-lenB;
            for(int i=0;i<k;i++){
                headA = headA.next;
            }
        }else if(lenA<lenB){
            int k = lenB-lenA;
            for(int i=0;i<k;i++){
                headB = headB.next;
            }
        }
        // 两个链表一起走 直到节点相同
        while(headA!=null && headB!=null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;

    }
    public int getLen(ListNode node){
        int len=0;
        while(node!=null){
            len++;
            node = node.next;
        }
        return len;
    }
}
