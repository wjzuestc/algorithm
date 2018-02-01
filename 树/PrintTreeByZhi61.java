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
 * ֮���δ�ӡ����������ջ��ʵ�֣���һ�������У�����Ϊ��һ�У����ұ��������һ��ջ1��
 * Ȼ������ڶ���ʱ�����������ջ2��������ջ��ʵ�֣���һ�������У�����Ϊ��һ�У����ұ��������һ��ջ1��
 * Ȼ������ڶ���ʱ�����������ջ2
 */
public class PrintTreeByZhi61 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return list;
        }
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        int level = 1;    //�����ж������ұ��������������
        
        stack1.push(pRoot);

        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> nodeList = new ArrayList<>();
            // ��Ҫ���ұ���stack1���ӽڵ����stack2
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