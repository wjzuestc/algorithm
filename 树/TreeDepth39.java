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
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 * ���ı���  �ݹ�ʵ��
 */
public class TreeDepth39 {
    public int TreeDepth(TreeNode root) {
		if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}