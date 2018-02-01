/**
 * 题目描述:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
             假设输入的数组的任意两个数字都互不相同。
			 
   注意：二叉搜索树后序遍历的特点
 */
public class VerifySquenceOfBST24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        
        return verifyBST(sequence, 0, sequence.length - 1);
        
    }
    
    public boolean verifyBST(int [] sequence, int start, int end) {
        // 如果start >= end 就说明没有左右子树了
        if (start >= end) {
            return true;
        }
        //后序遍历最后一个是根
        int root = sequence[end];
        //找左子树部分
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        // 右子树部分 如果右子树部分还有小于根的，就要直接返回false
        int index = i;
        for (i = index; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        // 再递归验证
        return verifyBST(sequence, start, index - 1) && verifyBST(sequence, index, end - 1);
    }
    
}