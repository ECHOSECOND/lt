package lianbiao;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

public class suijilianbiaodefuzhi {

    /**
     * 第一种思路 是先借助 hash表
     *
     * 存储的是原节点跟clone节点的关系。这种好理解些。
     *
     * 然后遍历原链表。 从map取复制的链表，包括 random链表
     *
     * 为什么不能一次性复制节点的同时复制random？因为复制random时random指向的节点可能在后面，还没复制到。
     *
     * 所以先走一遍复制逻辑，才能在第二次迭代里面处理random
     *
     * @param head
     * @return
     */

    public ListNode copyRandomList(ListNode head) {
        // 方法二 使用map存储的方法 map会同时存储着random
        // map记录原节点和复制节点的关系；自然random节点也会对应复制的random节点关系
        Map<ListNode, ListNode> mapListNode = new HashMap();
        ListNode cur = head;
        while(cur!=null){
            ListNode clone = new ListNode(cur.val);
            mapListNode.put(cur, clone); // 这里ListNode.random 也作为ListNode，与复制的random ListNode的关系被保存了下来
            cur = cur.next;
        }
        // 注意这里定义虚拟头节点 和 定义头节点的cur一定要同时出现！！！
        ListNode tmp = new ListNode(-1);
        ListNode tmpCur = tmp;
        ListNode cur2 = head;
        while(cur2!=null){
            ListNode cloneListNode = mapListNode.get(cur2);
            tmpCur.next = cloneListNode;
            cloneListNode.random = mapListNode.get(cur2.random); // mapListNode.get(cur2.random) 对应random的复制节点
            tmpCur = tmpCur.next;
            cur2 = cur2.next;
        }
        return tmp.next;
    }


    public ListNode copyRandomList2(ListNode head) {
        // 方法一、可以使用map 存储ListNode和复制ListNode的对应关系。处理B
        // ListNode的random时，原节点的ranodm也作为链表中的一个ListNode，可以通过map找到clone后的节点A【复制后的链表的其中一个ListNode】；这样 B.random = A

        // 方法二、可以将clone的节点挂到当前ListNode.next
        // 然后处理random： clone的节点的random一定是ListNode.random.next
        // 跳跃式分离出新ListNode

        // clone的ListNode挂在了原ListNode的后面，自然clone的random也在原random的后面
        ListNode cur = head; // 不改变head.next 只是不断变换cur 这样 就不会影响原链表head
        while (cur != null) {
            ListNode next = cur.next;
            ListNode clone = new ListNode(cur.val);
            cur.next = clone;
            clone.next = next;
            cur = next;
        }

        // 处理random
        ListNode cur2 = head;
        while (cur2 != null) {
            ListNode random = cur2.random;
            if(random!=null) {
                cur2.next.random = random.next;
            }
            cur2 = cur2.next.next;
        }

        /**
         * 第二种思路 不借助额外的空间 通过三步，先复制、挂靠；其次是 设置random；最后是 分离
         *
         * 原链表：
         * A -> B -> C -> D
         * |    |    |    |
         * C    A    D    B
         *
         * 步骤1：插入复制节点
         * A -> A' -> B -> B' -> C -> C' -> D -> D'
         *
         * 步骤2：设置random指针
         * A'.random = A.random.next (即C')
         * B'.random = B.random.next (即A')
         * ...
         *
         * 步骤3：分离链表
         * A -> B -> C -> D
         * A' -> B' -> C' -> D'
         */

        // 分离 或者将分离 写到上面也可以！！
        ListNode tmp = new ListNode(-1);
        ListNode tmpCur = tmp;
        ListNode cur3 = head;
        while (cur3 != null) {
            tmpCur.next = cur3.next;
            tmpCur = tmpCur.next;
            cur3 = cur3.next.next;
        }
        return tmp.next;
    }
}
