/**
 * 题目描述:写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 位运算  不进位相加sum（异或实现）  求进位carry（并，及移位）   sum+carry(又重复前两步)
 */

public class Add47 {
    public int add(int num1,int num2) {
        if (num2 == 0) {
            return num1;
        }
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        // 递归相加（加进位）
        return Add(sum, carry);
    }
}