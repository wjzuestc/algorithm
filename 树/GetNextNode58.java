/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
/*
  ��Ŀ����:
     ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
  �������������� pNode�Ǹ��Ľڵ㣬��������һ���ڵ�
  1. ��������ڵ�������������ô��һ���ڵ�϶���������������ڵ�
  2. ���û���������� 2.1 �����ǰ�ڵ����丸�ڵ������������ô���ڵ�϶�����һ����
  					2.2 �����ǰ�ڵ㻹���丸�ڵ������������ô��һֱ�����ң�ֱ�������丸�ڵ��������Ϊֹ������Ϊ�գ�˵���������ҵ���һ����
*/

public class GetNextNode58 {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // ��������������򷵻�������������ڵ�
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            // û�������������Ǹ��ڵ��������������һ���ڵ����丸�ڵ�
            if (pNode.next != null && pNode.next.left == pNode) {
                return pNode.next;
            } 
            // û�������������Ǹ��ڵ��������������һ���ڵ���ֱ���Ǹ��ڵ��������Ϊֹ
            if (pNode.next != null && pNode.next.right == pNode) {
                pNode =  pNode.next;
                while (pNode.next != null && pNode.next.left != pNode) {
                    pNode =  pNode.next;
                }
                return pNode.next;
            }
        }
        // pNode.next == null �򷵻�null
        return null;
 
    }
}