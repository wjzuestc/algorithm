/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
   题目描述:输入一个链表，输出该链表中倒数第k个结点。
 * 1. 两个指针，一个先走k步，再和另一个一起走，可以实现一次遍历即可找到倒数第k个
      注意边界：如果先走k步，则判断条件是p1指针是否为null，如果走k-1步，则判断条件是p1.next是否为null   
               相当于后一个只遍历到最后一个节点即停止
   2. 遍历两次的做法：获得链表长度，然后直接遍历到 len - k位置
 */
public class FindKthToTail15 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        // p1 指针先走k步
        while (k > 0) {
            if (p1 == null) {
                return null;
            }
            k--;
            p1 = p1.next;
        } 
        // p1 p2 再一起走
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}