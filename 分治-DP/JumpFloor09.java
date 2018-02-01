/**
 * ��Ŀ����:һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
 * 쳲������ı���
 */
public class JumpFloor09 {
    public int jumpFloor(int target) {
	/*	
    	�˽ⷨ�д�������������ظ����㡣
    	if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
     */
	    if(target <= 0) {
            return -1;
        }
        if (target <= 2) {
            return target;
        }
        int num2 = 1;
        int num1 = 2;  // ����ָn-1�Ǹ��ע��������
        // f(n) = f(n-1) + f(n-2)
        for (int i = 3; i <= target; i++) {
            int temp = num1;
            num1 = num1 + num2;
            num2 = temp;
        }
        return num1;
	}
}