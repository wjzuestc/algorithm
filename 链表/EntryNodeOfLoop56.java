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
 * ��Ŀ������һ�������а����������ҳ�������Ļ�����ڽ�㡣
 * �����������ֽⷨ�� 1. ˫ָ�룬һ�������������ڻ��У�Ȼ���¼�����㣬����һ��ָ���ߵ��˵㣬��¼�ߵĲ�����Ϊk�����ǻ��Ĵ�С
                       ����������ָ���ͷ��ʼ��һ��ָ������k����Ȼ��һ���ߣ��ٴ������ĵ㼴�ǻ�����ڵ�
                    2. ����ָ�룬������Ȼ����һ���ٴ�ͷ��ʼ���ٴ������ĵ㼴����ڵ㣨�����ʿ��Խ���֤������·���ֶΣ�
   Ҫע�⣺�߽磬����ָ����жϣ��Լ��ж��Ƿ��л�
 */

public class EntryNodeOfLoop56 {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode node1 = getTheMeetingPoint(pHead);
        // ˵���������޻�
        if (node1 == null) {
            return null;
        }
        // �ڶ��������㼴�����
        ListNode node2 = pHead;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
    
    /**
     * ����ָ���������㡣
     * return null �Ļ���˵�����޻�
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
             // ָ�����ö���ָ��һ����ַ�ģ����Կ���ֱ������ж�
             if (p1 == p2) {
                 return p1;
             }
         }
         return null;
     }
    
}







