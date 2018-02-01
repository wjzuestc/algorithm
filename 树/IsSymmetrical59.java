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
 * ��Ŀ����:��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * ������˼������������⣺1. ������==�ң���==�󣬾��ǶԳƵ�
 *                      2. ��ָoffer��˼�룬�����ж�ǰ������������ң��Ƿ���ڶԳƱ����������󣩣����˼�뻹Ҫ����null
 */
public class IsSymmetrical59 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        // �ݹ��ж����������Ƿ����
        return isSymmetricalLeftAndRight(pRoot.left, pRoot.right);
    }
    
    boolean isSymmetricalLeftAndRight(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        // ��ǰ����ȣ�����������ҲҪ�Գ�
        if (left.val == right.val) {
           return isSymmetricalLeftAndRight(left.left, right.right) && isSymmetricalLeftAndRight(left.right, right.left);
        }
        return false;
    }
}