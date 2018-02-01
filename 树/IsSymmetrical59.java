/*
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
 * 题目描述:请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 有两种思想来解决此问题：1. 就是左==右，右==左，就是对称的
 *                      2. 剑指offer的思想，就是判断前序遍历（跟左右）是否等于对称遍历（根右左），这个思想还要考虑null
 */
public class IsSymmetrical59 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        // 递归判断左右子树是否相等
        return isSymmetricalLeftAndRight(pRoot.left, pRoot.right);
    }
    
    boolean isSymmetricalLeftAndRight(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        // 当前需相等，并且其子树也要对称
        if (left.val == right.val) {
           return isSymmetricalLeftAndRight(left.left, right.right) && isSymmetricalLeftAndRight(left.right, right.left);
        }
        return false;
    }
}