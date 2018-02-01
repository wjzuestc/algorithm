/**
 * ��Ŀ����:���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ���
 
 * 1.�򵥵�������������ÿ�����е�1��Ȼ���������ʱ�临�Ӷ�ΪO(nlogn)
 * 2.�ҹ���
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