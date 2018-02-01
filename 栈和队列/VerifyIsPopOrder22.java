import java.util.LinkedList;

/**
 * 题目描述:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
   假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
   但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class VerifyIsPopOrder22 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length <= 0 || popA == null || popA.length <= 0 || pushA.length != popA.length) {
            return false;
        }  
        LinkedList<Integer> stack = new LinkedList<>();
        int length = popA.length;
        int k = 0;
        for (int i = 0; i < length; i++) {
            // 先判断栈顶元素是否与弹出顺序一致
            if (!stack.isEmpty() && stack.peek() == popA[i]) {
                stack.pop();
                continue;
            }
  			while (k < length && pushA[k] != popA[i]) {
                stack.push(pushA[k]);
                k++;
            }
            // 跳出循环，是指k>=length，则push都结束了，还没找到想要找的数，则就返回false
            if (k >= length) {
                return false;
            }
            // 说明是由 pushA[k] == popA[i]相等跳出循环的，所以k要+1
            k++;
        }
        return true;
    }
}