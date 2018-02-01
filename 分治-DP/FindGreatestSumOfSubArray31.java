/**
 * 很简单的思想：1.如果前面是正，就要，否则就不要，从当前开始，用一个max来记录最大值
 *             2.用dp的思想来思考  dp[i]是到坐标为i的最大和
 */
public class FindGreatestSumOfSubArray31 {
    // dp
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0) {
            throw new NullPointerException();
        }
        int maxSum = 0x80000000;  //记录最大值
        int currSum = 0;
        for (int i = 0; i < array.length; i++) {
            //当当前和大于0，就考虑加上它，小于0，就抛弃前面的，从当前开始
            if (currSum >= 0) {
                currSum += array[i];
            } else {
                currSum = array[i];
            }
			if (currSum > maxSum) {
                maxSum = currSum;
            }          
        }
        return maxSum;
    }
}