/**
 * �ܼ򵥵�˼�룺1.���ǰ����������Ҫ������Ͳ�Ҫ���ӵ�ǰ��ʼ����һ��max����¼���ֵ
 *             2.��dp��˼����˼��  dp[i]�ǵ�����Ϊi������
 */
public class FindGreatestSumOfSubArray31 {
    // dp
    public int findGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0) {
            throw new NullPointerException();
        }
        int maxSum = 0x80000000;  //��¼���ֵ
        int currSum = 0;
        for (int i = 0; i < array.length; i++) {
            //����ǰ�ʹ���0���Ϳ��Ǽ�������С��0��������ǰ��ģ��ӵ�ǰ��ʼ
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