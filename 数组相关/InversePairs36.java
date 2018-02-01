/**
 * 求数组的逆序对，是指按照数组顺序，统计前一个数字大于后一个数字的逆序对。
   两种解法：1. O(n^2)解法，依次扫描，从头到尾，遍历到i位置的数字，就遍历判断其后边有没有比他小的
            2. O(nlogn)解法，归并排序，先分割到子数组，统计子数组的逆序对，再排序，然后统计上一级的逆序对，直到最后   此方法要空间复杂度O(n)
 */
public class InversePairs36 {
    
    private int pairsCount = 0;
    
    public int inversePairs(int [] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        
        inversePairsCore(array, 0, array.length - 1);
        return pairsCount % 1000000007;
    }
    
    //分割数组
     public void inversePairsCore(int [] array, int start, int end) {
         if (end <= start) {
             return;
         }
         int mid = start + (end - start) / 2;
         inversePairsCore(array, start, mid);
         inversePairsCore(array, mid + 1, end);
         
         meger(array, start, mid, end);
         
     }
    
    /**
     * 合并操作
     */
    public void meger(int [] array, int start, int mid, int end) {
        //辅助数组
        int[] copy = new int[end - start + 1];
        int left = mid;
        int right = end;
        int index = end - start;
        while (left >= start && right >= mid + 1) {
            if (array[right] > array[left]) {
                copy[index--] = array[right];
                right--;
            } else {
                copy[index--] = array[left];
                //防止pairsCount过大，产生越界
                if (pairsCount >= 1000000007) {
                    pairsCount %= 1000000007;
                }
                //要注意长度的  后-前+1
                pairsCount += (right - (mid + 1)) + 1;
                left--;
            }
        }
        while (left >= start) {
            copy[index--] = array[left];
            left--;
        }
        while (right >= mid + 1) {
            copy[index--] = array[right];
            right--;
        }
        //归并排序
        for(int i = 0; i < copy.length; i++) {
            array[start++] = copy[i];
        }
    }
}