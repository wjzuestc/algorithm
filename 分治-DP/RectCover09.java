/**
 * ��Ŀ����:���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
            ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ���.
			
 * 쳲������ı��Σ�f(n)���ŷţ�f(n-1) ���ŷţ������÷���������f(n-2)
 */
public class RectCover09 {
    public int rectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target <= 2) {
            return target;
        }
		int num2 = 1;
        int num1 = 2;
        for (int i = 3; i <= target; i++) {
            int temp = num1;
            num1 = num2 + num1;
            num2 = temp;
        }
        return num1;
    }
}