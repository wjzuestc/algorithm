/**
 * 题目描述:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 有多种解题思路：1. 移动数与1相与  统计  但是这里有负数的限制，负数左移会补1 
 *               2. 移动相与数1，可以，但是相当于每位都进行了判断
 *               3. n&(n-1) 这会让n的最后一位变为0，所以可以利用此性质
 */
public class NumberOf1Bit10 {
    public int numberOf1(int n) {
		int count = 0;
        while (n != 0) {
            n &= (n-1); 
        	count++;
        }
        return count;
    }
}