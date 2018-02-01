/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * ��Ŀ����:�������������ҳ����ǵĵ�һ��������㡣
 * ���������γɵ���Y�͡������ȱ�����������ĳ��ȣ����k������һ����ǰ����
 * ע����ʵ��ϸ��
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
        // �ֱ�����������ĳ���
        while (pNode1 != null) {
            pNode1 = pNode1.next;
            len1++;
        }
        while (pNode2 != null) {
            pNode2 = pNode2.next;
            len2++;
        }
        // ��������λ��
        pNode1 = pHead1;
        pNode2 = pHead2;
        // �ó����Ǹ���������k��
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
        // ע��Ƚϵ���ֵ����Ϊ������������
        while (pNode1 != null && pNode2 != null && pNode1.val != pNode2.val) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }
}











