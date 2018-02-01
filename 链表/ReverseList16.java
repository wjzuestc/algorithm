/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * ��Ŀ����:����һ��������ת�����������������Ԫ�ء�
 * ��ת����Ҫ��¼ǰ�к󣬿϶�Ҫ����ָ�롣ע���һ��ָ�룬ָ��null���ڶ���ָ��ָ��head���������ʵ�ַ�ת����
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