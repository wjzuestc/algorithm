/**
 * ��Ŀ����:дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 * λ����  ����λ���sum�����ʵ�֣�  ���λcarry����������λ��   sum+carry(���ظ�ǰ����)
 */

public class Add47 {
    public int add(int num1,int num2) {
        if (num2 == 0) {
            return num1;
        }
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        // �ݹ���ӣ��ӽ�λ��
        return Add(sum, carry);
    }
}