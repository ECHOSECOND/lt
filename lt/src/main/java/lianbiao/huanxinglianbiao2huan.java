package lianbiao;

import common.ListNode;

public class huanxinglianbiao2huan {

    /**
     * 变量定义
     * x：头结点到环形入口节点的距离（节点数）
     *
     * y：环形入口节点到快慢指针相遇点的距离
     *
     * z：相遇点到环形入口节点的距离
     *
     * n：fast 指针在环内绕的圈数（至少为 1）
     */

    /**
     * slow 总步数： x + y
     */

    /**
     * fast 总步数
     * x + y + n(y + z)
     */

    /**
     * x+y+n(y+z)=2(x+y) --》 x=(n−1)(y+z)+z  （一圈的节点数为 y + z） 从相遇处 绕了n-1圈 ，n=1时 没有绕圈 相遇处触发 两者再次相遇
     */
    //


    public ListNode detectCycle(ListNode head) {
        // 判断链表有环 并找到环的起点
        ListNode fast = head;
        ListNode slow = head;
        ListNode meetNode = null;

        // 1. 先找到 相遇处 快慢指针初始化为 head。 while 判断 slow、fast、fast.next 不为null

        while (slow != null && fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                meetNode = slow;
                break;
            }
        }
        // 链表无环
        if (meetNode == null) {
            return null;
        }

        // 2. 找到了相遇处后， 一个从head 一个从相遇处 两者再次相遇就是环入口

        ListNode cur = head;
        while (cur != null && meetNode != null) {
            if (cur == meetNode) {
                return cur;
            }
            cur = cur.next;
            meetNode = meetNode.next;
        }
        return null;

    }

    // 3. 找环的长度

//    def getCycleLength(head):
//    entry = detectCycle(head)  # 3.1 先找到环的入口
//    if not entry:
//            return 0  # 无环，长度为0
//
//            length = 1
//    walker = entry.next
//    while walker != entry:  # 3.2 绕环一圈计数，再次与自己遇到就是环长度
//    length += 1
//    walker = walker.next
//    return length

}
