/**
 * 题目描述:求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数
 
 * 1.简单的做就是依次求每个数中的1，然后加起来，时间复杂度为O(nlogn)
 * 2.找规律
 */
public class NumberOf1Between1AndN32 {
    public int NumberOf1Between1AndN_Solution(int n) {      
        int num = 0;
        for (int i = 0; i <= n; i++) {
            num += NumberOf1(i);
        }
        return num;
    }
    
     public int NumberOf1(int n) {
         int count = 0;
         while(n != 0) { 
             if ((n % 10) == 1) {
                 count++;
             }
             n /= 10; 
         }
         return count;
      }
}