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
 * 题目描述
   输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
   假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
   例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 前序遍历，第一个是根，然后把中序遍历分为两部分，再根据中序遍历的分的左子树、右子树部分，再把前序遍历分为两部分
   从而又和原问题一样了，所以继续递归
 */
public class ReConstructBinaryTree06 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0 || pre.length != in.length) {
            return null;
        }
       return constructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
    
    // 关键问题是划分 前、中序遍历。找到相应的位置即可实现递归
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