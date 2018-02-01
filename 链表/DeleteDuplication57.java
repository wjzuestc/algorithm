/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
/**
 * 题目描述：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 *           重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 删除值相等的链表，全部删除
 * 经典的三指针操作
 */
public class DeleteDuplication57 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //虚拟头节点，来解决头节点相等的问题
        ListNode preHead = new ListNode(0);
        ListNode pre = preHead;
        ListNode node = pHead;
        pre.next = node;
        //是否有相等的节点的标志位，因为此题是将有相等的节点全部删除
        boolean flag = false;
        ListNode next;
        while (node != null) {
            next = node.next;
            //相等判断条件
            while (next != null && node.val == next.val) {
                next = next.next;
                flag = true;
            }
            //如果有相等的话，则删除全部值。此时next指向的是第一个不相等节点，此情况下，pre指针是不需要移动的
            if (flag) {
                pre.next = next;
                node = next;
                flag = false;
            } else {
                //不相等，则移动pre，node和next，进行下一步比较
                 pre = node;
                 node = node.next;
            }
        }
        return preHead.next;
    }
}