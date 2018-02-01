/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 题目描述:输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 合并操作，参考归并排序的合并过程
 */
public class MergeSortedList17 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //虚拟头结点  
        ListNode head = new ListNode(0);
        ListNode list = head;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode node = new ListNode(list1.val);
                list.next = node;
                list = list.next;
                list1 = list1.next;
            } else {
                ListNode node = new ListNode(list2.val);
                list.next = node;
                list = list.next;
                list2 = list2.next;
            }
        }
        
        while (list1 != null) {
            ListNode node = new ListNode(list1.val);
            list.next = node;
            list = list.next;
            list1 = list1.next;
        }
        
        while (list2 != null) {
            ListNode node = new ListNode(list2.val);
            list.next = node;
            list = list.next;
            list2 = list2.next;
        }
        
        return head.next;         

    }
}