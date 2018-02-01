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
 *题目描述:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 
 * 排序的双向链表，肯定是中序遍历实现，则逻辑在中间实现
 * 双向链表：用一个tailNode来记录链表的尾节点，则当前节点指向尾，尾再指向当前
 */
public class ConvertSearchTreeToList27 {
    TreeNode head = null;  // 记录整个双向链表的头节点
    TreeNode curTrailHead = null;  // 记录当前形成的链表的尾节点  需要全局的
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        // 左中右
        Convert(pRootOfTree.left);
        
        if (head == null) {
            head = pRootOfTree;
            curTrailHead = pRootOfTree;
        } else {
            pRootOfTree.left = curTrailHead;
            curTrailHead.right = pRootOfTree;
            // 更新其尾节点
            curTrailHead = pRootOfTree;
        }

        
        Convert(pRootOfTree.right);
        return head;
    }

}