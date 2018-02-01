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
 * 题目描述：一个链表中包含环，请找出该链表的环的入口结点。
 * 此问题有两种解法： 1. 双指针，一步两步，相遇于环中，然后记录相遇点，再让一个指针走到此点，记录走的步数则为k，就是环的大小
                       则再让两个指针从头开始，一个指针先走k步，然后一起走，再次相遇的点即是环的入口点
                    2. 快慢指针，相遇，然后另一个再从头开始，再次相遇的点即是入口点（此性质可以进行证明，将路径分段）
   要注意：边界，快慢指针的判断，以及判断是否有环
 */

public class EntryNodeOfLoop56 {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode node1 = getTheMeetingPoint(pHead);
        // 说明此链表无环
        if (node1 == null) {
            return null;
        }
        // 第二轮相遇点即是入口
        ListNode node2 = pHead;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
    
    /**
     * 快慢指针获得相遇点。
     * return null 的话，说明，无环
     */
     public ListNode getTheMeetingPoint(ListNode pHead) {
         if(pHead == null) {
             return null;
         }
         ListNode p1 = pHead;
         ListNode p2 = pHead;
         while (p2 != null) {
             p1 = p1.next;
             p2 = p2.next;
             if (p2 != null) {
                 p2 = p2.next;
             }
             // 指针引用都是指向一个地址的，所以可以直接相等判断
             if (p1 == p2) {
                 return p1;
             }
         }
         return null;
     }
    
}







