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
 * 题目描述：
   给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * 中序遍历到第k个元素即可 1. 用一个容器来保存遍历结果
                        2. 递归实现，需要用一个全局变量来保存遍历的数目
 */
public class KthNode63 {
    private int kthNum = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        kthNum = k;
        return KthNodeCore(pRoot);
    }
    
     //中序遍历，实现肯定就是在中间的逻辑    
     TreeNode KthNodeCore(TreeNode pRoot) {
         // 感觉如果在遍历时写 if(pRoot.left != null){}  那么就可以不写这个边界
         // 但是，如果是在循环中遍历，就得写 if(pRoot.left != null) 才能进行下一步遍历
         //if (pRoot == null) {
           //  return null;
         //}
         TreeNode target = null;
         // 左中右
         if(pRoot.left!=null) {
             target = KthNodeCore(pRoot.left);
         }
         // 左子树没找到
         if (target == null) {
             if (kthNum == 1) {
                 target = pRoot;
             }
             kthNum--;
         }
         // 当前节点也不是
         if (target == null && pRoot.right != null) {
             target = KthNodeCore(pRoot.right);
         }
         return target;
     }
}






