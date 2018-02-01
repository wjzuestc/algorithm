/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
/*
  题目描述:
     给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
  中序遍历：左根右 pNode是给的节点，返回其下一个节点
  1. 如果给定节点有右子树，那么下一个节点肯定是右子树的最左节点
  2. 如果没有右子树： 2.1 如果当前节点是其父节点的左子树，那么父节点肯定是下一个数
  					2.2 如果当前节点还是其父节点的右子树，那么就一直向上找，直到它是其父节点的左子树为止，或者为空（说明它是最右的那一个）
*/

public class GetNextNode58 {
    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 如果有右子树，则返回右子树的最左节点
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            // 没有右子树，且是父节点的左子树，则下一个节点是其父节点
            if (pNode.next != null && pNode.next.left == pNode) {
                return pNode.next;
            } 
            // 没有右子树，且是父节点的右子树，则下一个节点是直到是父节点的左子树为止
            if (pNode.next != null && pNode.next.right == pNode) {
                pNode =  pNode.next;
                while (pNode.next != null && pNode.next.left != pNode) {
                    pNode =  pNode.next;
                }
                return pNode.next;
            }
        }
        // pNode.next == null 则返回null
        return null;
 
    }
}