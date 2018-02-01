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
 * ���Ĳ�α������ö���ʵ��
 * ��һ����Ҫ�Ȱ�root���
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
            // ��һ�������жϴ˲���Ҫ��ӡ����Ŀ   
            int end = queue.size();
            // һ�ΰ�������еĽڵ��ֵ����
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