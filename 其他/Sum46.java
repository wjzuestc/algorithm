/**
 * ��Ŀ����:��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
 
 * ���ù��캯����ʵ�֣�����n��������ɹ�����������
 * �����м���С�㣺��̬�������Ա��Ǿ�̬�������ã����Ǿ�̬�������ɱ���̬�������á�������̬�����;�̬��������������ģ����Զ���Ҳ���Ե���
 * 
 *
 * ��������õݹ�ʵ�֣���û��˵�����õݹ�  n + f(n-1);
 */
public class Sum46 {
  /**
    private static int sum = 0;
    private static int num = 0;
    
    public Solution() {
        num++;
        sum += num;
    }
    public int Sum_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        Solution[] res = new Solution[n]; // ��ʵ����û�д�������ֻ��һ������
        return sum;
    }
   */
    //�ϱ��ù��캯�������ԣ���֪��Ϊ�Ρ�����
     public int Sum_Solution(int n) {
         if (n == 0) {
             return 0;
         }
         return n + Sum_Solution(n - 1);
     }
}