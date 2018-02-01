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
 * 题目描述:输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 递归实现，先找相等节点，再每个节点递归判断
 */
public class HasSubtree18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        // 如果当前节点相等，就进行判断子树是否相等
        boolean result = false;
		// 先判断当前节点是不是
        result = doesTree1HaveTree2(root1, root2) &&  doesTree1HaveTree2(root1, root2);

        // 如果当前节点不是，再判断子树中是否存在
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
        // node1结束了，node2还存在
        if (node1 == null) {
            return false;
        }
        // 当前节点和子节点都要相等
        if (node1.val == node2.val) {
            return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
        }
        return false;
    }
}