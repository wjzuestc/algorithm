/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 题目描述:输入两个链表，找出它们的第一个公共结点。
 * 两条链表形成的是Y型。所以先遍历两个链表的长度，相差k步，再一步步前进。
 * 注意其实现细节
 */
public class FindFirstCommonNode37 {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode pNode1 = pHead1;
        ListNode pNode2 = pHead2;
        int len1 = 0;
        int len2 = 0;
        // 分别求两个链表的长度
        while (pNode1 != null) {
            pNode1 = pNode1.next;
            len1++;
        }
        while (pNode2 != null) {
            pNode2 = pNode2.next;
            len2++;
        }
        // 再重置其位置
        pNode1 = pHead1;
        pNode2 = pHead2;
        // 让长的那个链表先走k步
        if (len1 > len2) {
           for (int i = 1; i <= len1 - len2; i++) {
              pNode1 = pNode1.next;
           }
        }
        if (len2 > len1) {
           for (int i = 1; i <= len2 - len1; i++) {
              pNode2 = pNode2.next;
           }
        }
        // 注意比较的是值，因为这是两个链表
        while (pNode1 != null && pNode2 != null && pNode1.val != pNode2.val) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }
}











