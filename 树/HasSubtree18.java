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
 * ��Ŀ����:�������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * �ݹ�ʵ�֣�������Ƚڵ㣬��ÿ���ڵ�ݹ��ж�
 */
public class HasSubtree18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        // �����ǰ�ڵ���ȣ��ͽ����ж������Ƿ����
        boolean result = false;
		// ���жϵ�ǰ�ڵ��ǲ���
        result = doesTree1HaveTree2(root1, root2) &&  doesTree1HaveTree2(root1, root2);

        // �����ǰ�ڵ㲻�ǣ����ж��������Ƿ����
        if (!result) {
           result = HasSubtree(root1.left, root2);
        }
        if (!result) {
           result = HasSubtree(root1.right, root2);
        }
        return result;
    }
 
    public boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        // node1�����ˣ�node2������
        if (node1 == null) {
            return false;
        }
        // ��ǰ�ڵ���ӽڵ㶼Ҫ���
        if (node1.val == node2.val) {
            return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
        }
        return false;
    }
}