//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
//��num1[0],num2[0]����Ϊ���ؽ��
/**
  ��Ŀ����:һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 * 1. hash����ԣ����ǻ���O(n)�Ŀռ临�Ӷ�
 * 2. ����O��n���ռ临�Ӷ�ʱ�����ֻ��1������һ�Σ�����^���������ɡ�����������ֻ����һ�εģ�������ȷ�Ϊÿ����ֻ����һ����������
 */
public class FindNumsAppearOnce40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length <= 0) {
            return;
        }
        // �ȵõ�����ֻ����һ�ε����ֵ������
        int num = getXor(array, 0, array.length - 1);
        // ���� ��һ������1 ��λ��Ϊ�����֡���Ϊ�������ȵĻ��������Ϊ1����϶�һ��Ϊ1��һ��Ϊ0
        int bitIndex = 1;
        while ((num & bitIndex) == 0) {
            bitIndex <<= 1;
        }
        // �������Ϊ������  ��������������ֳ������֣�Ȼ�����xor������ֻ��Ҫ������ʱ���ж�һ�£��Ƿ�Ҫ����������
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
     * ��������
     */
    public int getXor(int [] array, int start, int end) {
        int num = 0;
        for (int i = start; i <= end; i++) {
            num ^= array[i];
        }
        return num;
    } 
}