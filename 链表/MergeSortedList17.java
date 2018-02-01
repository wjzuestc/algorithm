/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * ��Ŀ����:���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * �ϲ��������ο��鲢����ĺϲ�����
 */
public class MergeSortedList17 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //����ͷ���  
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