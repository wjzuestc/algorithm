/**
 * 题目描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 只要判断左右子树的高度不超过1，递归实现
 * 这样做应该会有大量的子问题存在，子树高度被算了很多次
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
     * 求树的高度
     */
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}