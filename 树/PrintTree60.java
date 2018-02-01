import java.util.*;
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
 * 树的层次遍历，用队列实现
 * 第一步就要先把root入队
 */
public class PrintTree60 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> nodeVal = new ArrayList<>();
            // 用一个数来判断此层需要打印的数目   
            int end = queue.size();
            // 一次把这层所有的节点的值保存
            while (end != 0) {
                TreeNode node = queue.poll();
                nodeVal.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                end--;
            }
            list.add(nodeVal);
        }
        return list;
    }
    
}