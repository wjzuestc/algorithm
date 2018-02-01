/**
 * 题目描述:统计一个数字在排序数组中出现的次数。
 
   hash表可以 遍历也可以 但是排序数组肯定有用  二分啊.
   二分的变形：找正好大于k的那个数的位置 与 正好小于k 的位置  然后相减   时间复杂度为 O(logn)
   定位k第一次出现的位置 和 最后一次出现的位置
 */
public class GetNumberOfK38 {
    public int getNumberOfK(int [] array , int k) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid1 = (left + right) >> 1;
        // 找第一个k
        while (left <= right) {
            if (array[mid1] >= k) {
                right = mid1 - 1; 
            } else {
                left = mid1 + 1;  // < left 是始终指向小于k的  最后也是+1获得第一个k
            }
            
            mid1 = (left + right) >> 1;
        }
        mid1 = left;
        
        left = 0;
        right = array.length - 1;
        int mid2 = (left + right) >> 1;
        //找最后一个k
        while (left <= right) {
            if (array[mid2] > k) {
                right = mid2 - 1;   // 大于k的  获得最后一个k
            } else {
                left = mid2 + 1; 
            }
            
            mid2 = (left + right) >> 1;
        }
        mid2 = right;
        
        return mid2 - mid1 + 1;
    }
}