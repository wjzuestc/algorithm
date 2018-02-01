/**
 * ��Ŀ����:����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No��
             �������������������������ֶ�������ͬ��
			 
   ע�⣺��������������������ص�
 */
public class VerifySquenceOfBST24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        
        return verifyBST(sequence, 0, sequence.length - 1);
        
    }
    
    public boolean verifyBST(int [] sequence, int start, int end) {
        // ���start >= end ��˵��û������������
        if (start >= end) {
            return true;
        }
        //����������һ���Ǹ�
        int root = sequence[end];
        //������������
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        // ���������� ������������ֻ���С�ڸ��ģ���Ҫֱ�ӷ���false
        int index = i;
        for (i = index; i < end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        // �ٵݹ���֤
        return verifyBST(sequence, start, index - 1) && verifyBST(sequence, index, end - 1);
    }
    
}