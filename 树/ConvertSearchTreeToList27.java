/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
/**
 *��Ŀ����:����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 
 * �����˫�������϶����������ʵ�֣����߼����м�ʵ��
 * ˫��������һ��tailNode����¼�����β�ڵ㣬��ǰ�ڵ�ָ��β��β��ָ��ǰ
 */
public class ConvertSearchTreeToList27 {
    TreeNode head = null;  // ��¼����˫�������ͷ�ڵ�
    TreeNode curTrailHead = null;  // ��¼��ǰ�γɵ������β�ڵ�  ��Ҫȫ�ֵ�
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        // ������
        Convert(pRootOfTree.left);
        
        if (head == null) {
            head = pRootOfTree;
            curTrailHead = pRootOfTree;
        } else {
            pRootOfTree.left = curTrailHead;
            curTrailHead.right = pRootOfTree;
            // ������β�ڵ�
            curTrailHead = pRootOfTree;
        }

        
        Convert(pRootOfTree.right);
        return head;
    }

}