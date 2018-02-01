import java.util.ArrayList;
/**
 * 题目描述:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
   其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 
 * 为了能够在O（n）时间内解决，将B[i] = C[i]*D[i]  前后两部分
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