import java.util.ArrayList;
/**
 * 题目描述:输出所有和为S的连续正数序列
 
 * 用双指针来实现，初始是left = 1，right=2，小于的话就向后移动right，大的话就向后移动left
 * 至少有两个数，说明递归结束条件是left < (s+1)/2
   连续的整数构成sum
 */
public class FindContinuousSequence41 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (sum <= 2) {
            return list;
        }
        int left = 1;
        int right = 2;
        while (left < (sum + 1) / 2) {
            ArrayList<Integer> seq = new ArrayList<Integer>();
            int sumTwo = 0;
            //计算连续的sum值
            for (int i = left; i <= right; i++) {
                sumTwo += i;
            }
            if (sumTwo < sum) {
                right++;
            } else if (sumTwo > sum) {
                left++;
            } else {
                // 相等的话，构成一个解，然后更新left，right
                for (int i = left; i <= right; i++) {
                    seq.add(i);
                }
                list.add(seq);
                left++;
                right++;
            }
        }
        return list;
    }
}