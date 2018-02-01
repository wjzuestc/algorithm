/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/

import java.util.ArrayList;
/**
 * ��Ŀ����:����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 * 1. ���ü�����������һ��   ���ڿռ临�Ӷ�
   2. ���õݹ�ʵ�֣����õݹ����ʵ��   �ݹ�Ҳ���ڿռ临�Ӷ�
   3. ��ת����ʵ�֣�������Ըı�ԭ���еĻ�
 */
public class PrintListFromTailToHead05 {
    
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //�����������ȫ�ֱ������÷���ֵ��ʵ��
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null) {
            return list;
        }
        list.addAll(printListFromTailToHead(listNode.next));
        list.add(listNode.val);
        return list;
    }
}