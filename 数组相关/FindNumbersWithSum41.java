import java.util.ArrayList;
/**
 * 题目描述:输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
             如果有多对数字的和等于S，输出两个数的乘积最小的。
 
 * 前后双指针
 */
public class FindNumbersWithSum41 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length <= 0) {
            return list;
        }
        int left = 0;
        int right = array.length - 1;
        int sumTwo = 0;
        int multi = 0x7ffffff;   // 用来保存每次的乘积
        while (left < right) {
            sumTwo = array[left] + array[right];
            if (sumTwo < sum) {
                left++;
            } else if (sumTwo > sum) {
                right--;
            } else {
                // 相等情况  如果乘积小于上次的值，则进行更新  否则查找下一对 
                // 下一次更新肯定是left++，right--，而不是一个变化，sum = num1+num2，如果num1变，那num2肯定也要变
                if (array[left] * array[right] < multi) {
                    if (list.size() == 2) {
                        list.remove(0);
                        list.remove(1);
                    }
                    multi = array[left] * array[right];
                    list.add(array[left]);
                    list.add(array[right]);
                }
                left++;
                right--;
            }
        }
        return list;
    }
}