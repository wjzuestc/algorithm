/**
 * 题目描述:大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 
 * DP f(n) = f(n-1)+f(n-2)   1 1 2 3 5.... 
 * 与跳台阶的初始条件不同
 */
public class Fibonacci09 {
    public int Fibonacci(int n) {
		if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int num1 = 1;
        int num2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = num1;
            num1 = num1 + num2;
            num2 = temp;
        }
        return num1;
    }
}