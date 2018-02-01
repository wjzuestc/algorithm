import java.util.*;

/**
 * 题目描述:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 这题有多种解法：1. O(nlogn)解法，排序，然后直接找到 中间的数字即可
                 2. O(n)空间复杂度，O(n)时间复杂度解法，用一个hash表来实现
                 3. O(n)的实现，用Partition函数来实现找到index = n / 2 
                 4. O(n)的实现，用count来计数，相同就加1，不想同就减1，最后返回最后一个将count设为1的数  必须有解，才能用这种方法。
                 5. O(n)的实现 遍历，去掉不相等的   必须有解，才能用这种方法。
 */ 
public class MoreThanHalfNum29 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int count = 0;
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
                count++;
                continue;
            }
            if (num == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        // 必须有解，才能用这种方法。
        if (!hasSolution(array, num)) {
            return 0;
        }
        // 返回最后一个将count设为1的数
        return num;
    }
    
    
    // 遍历查看是否有解
    public boolean hasSolution(int[] array, int num) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return true;
        }
        return false;
    }
       
    
    
}