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
 * ¶þ²æÊ÷¾µÏñ
 * µÝ¹éÊµÏÖ  
 */ 
public class Mirror19 {
    public void mirror(TreeNode root) {
		mirrorTree(root);
    }
    
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = temp;
        return root;
    }
}