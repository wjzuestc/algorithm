/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 题目描述:输入一个链表，反转链表后，输出链表的所有元素。
 * 翻转链表，要记录前中后，肯定要三个指针。注意第一个指针，指向null，第二个指针指向head，会很容易实现翻转链表
 */
public class ReverseList16 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}