import java.util.ArrayList;
/**
 * ��Ŀ����:����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
   ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 
 * Ϊ���ܹ���O��n��ʱ���ڽ������B[i] = C[i]*D[i]  ǰ��������
 * C[i] = C[i-1]*A[i-1]
 * D[i] = D[i+1]*[i+1]
 */
public class MultiplyArray52 {
    public int[] multiply(int[] A) {
		if (A == null || A.length <= 0) {
            return null;
        }
        int len = A.length;
        int[] c = new int[len];
        int[] d = new int[len];
        int[] reslut = new int[len];
        c[0] = 1;
        d[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            c[i] = c[i-1]*A[i-1];
        }
        for (int i = len - 2; i >= 0; i--) {
            d[i] = d[i+1]*A[i+1];
        }
        for (int i = 0; i < len; i++) {
            reslut[i] = c[i]*d[i];
        }
        return reslut;
    }
}