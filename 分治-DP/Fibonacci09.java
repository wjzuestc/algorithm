/**
 * ��Ŀ����:��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n�n<=39
 
 * DP f(n) = f(n-1)+f(n-2)   1 1 2 3 5.... 
 * ����̨�׵ĳ�ʼ������ͬ
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