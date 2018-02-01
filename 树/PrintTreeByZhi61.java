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
 * 之字形打印树，用两个栈来实现，第一个奇数行（首行为第一行）左右遍历放入第一个栈1，
 * 然后遍历第二行时右左遍历放在栈2，用两个栈来实现，第一个奇数行（首行为第一行）左右遍历放入第一个栈1，
 * 然后遍历第二行时右左遍历放在栈2
 */
public class PrintTreeByZhi61 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return list;
        }
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        int level = 1;    //用来判断是左右遍历还是右左遍历
        
        stack1.push(pRoot);

        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> nodeList = new ArrayList<>();
            // 需要左右遍历stack1，子节点放入stack2
            if ((level & 1) == 1) {
                level++;
                while(!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    nodeList.add(node.val);
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                }
            } else {
                level++;
                while(!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    nodeList.add(node.val);
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                }
            }
            list.add(nodeList);
        }
        return list;
    }

}