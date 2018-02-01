import java.util.LinkedList;
/**
 * 约瑟夫环问题：1. 用链表来模拟环
 *               2. 归纳规律
 */
public class JosephLoop45 {
    public int LastRemaining_Solution(int n, int m) { 
        if (n <= 0 || m <= 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        // 初始化编号
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        // 模拟约瑟夫问题
        int start = 0;   // 报数起始点
        int count = 1;   // 用来记录是否该出队了
        while(list.size() > 1 ) {
            int len = list.size();
            while(count < m) {
                count++;
                start++;
                // 环形来遍历
                if (start >= len) {
                    start = 0;
                }
            }
            list.remove(start);
            count = 1;   
            // 要判断是否上一步出队的是最后一个，要不然会有空指针问题
            if (start == len - 1) {
                start = 0;
            }
        }
        return list.get(start);
    }
}