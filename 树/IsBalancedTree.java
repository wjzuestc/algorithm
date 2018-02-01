/**
 * ��Ŀ����������һ�ö��������жϸö������Ƿ���ƽ���������
 * ֻҪ�ж����������ĸ߶Ȳ�����1���ݹ�ʵ��
 * ������Ӧ�û��д�������������ڣ������߶ȱ����˺ܶ��
 */
public class IsBalancedTree {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    
    /**
     * �����ĸ߶�
     */
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}