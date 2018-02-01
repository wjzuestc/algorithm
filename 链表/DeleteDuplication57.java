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
 * ��Ŀ��������һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬
 *           �ظ��Ľ�㲻��������������ͷָ�롣 ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 * ɾ��ֵ��ȵ�����ȫ��ɾ��
 * �������ָ�����
 */
public class DeleteDuplication57 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //����ͷ�ڵ㣬�����ͷ�ڵ���ȵ�����
        ListNode preHead = new ListNode(0);
        ListNode pre = preHead;
        ListNode node = pHead;
        pre.next = node;
        //�Ƿ�����ȵĽڵ�ı�־λ����Ϊ�����ǽ�����ȵĽڵ�ȫ��ɾ��
        boolean flag = false;
        ListNode next;
        while (node != null) {
            next = node.next;
            //����ж�����
            while (next != null && node.val == next.val) {
                next = next.next;
                flag = true;
            }
            //�������ȵĻ�����ɾ��ȫ��ֵ����ʱnextָ����ǵ�һ������Ƚڵ㣬������£�preָ���ǲ���Ҫ�ƶ���
            if (flag) {
                pre.next = next;
                node = next;
                flag = false;
            } else {
                //����ȣ����ƶ�pre��node��next��������һ���Ƚ�
                 pre = node;
                 node = node.next;
            }
        }
        return preHead.next;
    }
}