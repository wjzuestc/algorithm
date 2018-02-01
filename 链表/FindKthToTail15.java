/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
   ��Ŀ����:����һ����������������е�����k����㡣
 * 1. ����ָ�룬һ������k�����ٺ���һ��һ���ߣ�����ʵ��һ�α��������ҵ�������k��
      ע��߽磺�������k�������ж�������p1ָ���Ƿ�Ϊnull�������k-1�������ж�������p1.next�Ƿ�Ϊnull   
               �൱�ں�һ��ֻ���������һ���ڵ㼴ֹͣ
   2. �������ε���������������ȣ�Ȼ��ֱ�ӱ����� len - kλ��
 */
public class FindKthToTail15 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        // p1 ָ������k��
        while (k > 0) {
            if (p1 == null) {
                return null;
            }
            k--;
            p1 = p1.next;
        } 
        // p1 p2 ��һ����
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}