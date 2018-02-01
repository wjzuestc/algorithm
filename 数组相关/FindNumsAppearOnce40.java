//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
/**
  题目描述:一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 1. hash表可以，但是会有O(n)的空间复杂度
 * 2. 不用O（n）空间复杂度时，如果只有1个出现一次，则用^异或操作即可。但是有两个只出现一次的，则可以先分为每部分只包含一个的两部分
 */
public class FindNumsAppearOnce40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length <= 0) {
            return;
        }
        // 先得到两个只出现一次的数字的异或结果
        int num = getXor(array, 0, array.length - 1);
        // 按照 第一个出现1 的位分为两部分。因为如果不相等的话，异或结果为1，则肯定一个为1，一个为0
        int bitIndex = 1;
        while ((num & bitIndex) == 0) {
            bitIndex <<= 1;
        }
        // 将数组分为两部分  不用真正把数组分成两部分，然后调用xor函数，只需要在异或的时候判断一下，是否要异或此数即可
        int number1 = 0;
        int number2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & bitIndex) == 0) {
                number1 ^= array[i];
            } else {
                number2 ^= array[i];
            }
        }
        num1[0] = number1;
        num2[0] = number2;
    }
    
    /**
     * 获得异或结果
     */
    public int getXor(int [] array, int start, int end) {
        int num = 0;
        for (int i = start; i <= end; i++) {
            num ^= array[i];
        }
        return num;
    } 
}