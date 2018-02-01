import java.util.ArrayList;
/**
 * 旋转数组中的最小数字
 * 数组是排序的变形，所以设想是否可以用二分来实现
 * left是在前半部分，right是在后边的部分，最后跳出条件是left指向前部分最后一个，right指向后部分最前一个
 */
public class MinNumberInRotateArray08 {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        // 注意：移位运算符是的优先级是小于算术运算符的
        int mid = (left + (right - left)) >> 1;
        if (array[left] == array[right] && array[left] == array[mid]) {
            return minNumberInSequenceArray(array);
        }
        while ((right - left) != 1) {
            mid = left + (right - left) / 2;
            // 要考虑有重复元素的情况，所以是大于等于
            if (array[mid] >= array[left]) {
                left = mid;
            } 
            if (array[mid] < array[left]) {
                right = mid;
            }
        }
        return array[right];
    }
    
    // 如果都相等，则进行顺序查找
    public int minNumberInSequenceArray(int[] nums) {
        int minNum = nums[0];
        for (int i = 0; i < nums.length; i++) {
			if (minNum > nums[i]) {
                minNum = nums[i];
            }            
        }
        return minNum;
    }
}