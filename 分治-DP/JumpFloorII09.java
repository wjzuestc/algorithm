/**
 * ��Ŀ����:һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
   �����������һ��n����̨���ܹ��ж�����������
   
 * ��ѧ���ɷ��� �ܹ���2^(n-1)��
 */
public class JumpFloorII09 {
    public int jumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        }
        return (int)Math.pow(2, target - 1);
    }
}