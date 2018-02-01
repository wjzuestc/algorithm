/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * ��Ŀ����
   ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
   ���������ǰ���������������Ľ���ж������ظ������֡�
   ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * ǰ���������һ���Ǹ���Ȼ������������Ϊ�����֣��ٸ�����������ķֵ������������������֣��ٰ�ǰ�������Ϊ������
   �Ӷ��ֺ�ԭ����һ���ˣ����Լ����ݹ�
 */
public class ReConstructBinaryTree06 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0 || pre.length != in.length) {
            return null;
        }
       return constructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
    
    // �ؼ������ǻ��� ǰ������������ҵ���Ӧ��λ�ü���ʵ�ֵݹ�
    public TreeNode constructBinaryTree(int [] pre,int [] in,int start1, int end1, int start2, int end2) {
        if (start1 > end1 || start2 > end2) {
            return null;
        }
        TreeNode root = new TreeNode(pre[start1]);
        int indexIn = start2;
        for (; indexIn <= end2; indexIn++) {
            if (in[indexIn] == root.val) {
                break;
            }
        }
        int num = indexIn - start2;
        
        root.left = constructBinaryTree(pre, in, start1 + 1, start1 + num, start2, indexIn - 1);
        
        root.right = constructBinaryTree(pre, in, start1 + num + 1, end1, indexIn + 1, end2);
        
        return root;
    }
}