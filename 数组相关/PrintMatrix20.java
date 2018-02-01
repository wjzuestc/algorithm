/**
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣����磬����������¾��� 
 *                    1 2 3 4 
 *                    5 6 7 8 
 *                    9 10 11 12 
 *                    13 14 15 16 
 *  �����δ�ӡ������
 *        1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
import java.util.*;
 
public class PrintMatrix20{
    ArrayList<Integer> list = new ArrayList<>();
     
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        //��ʼλ��  start = (0,0) (1,1) ...
        while(rows > start * 2 && columns > start * 2){
            printMatrixInCircle(matrix, rows, columns, start);
            start++;
        }
        return list;
    }
     
    /**
     * ���ܣ���ӡһȦ
     */
    public void printMatrixInCircle(int[][] matrix, int rows, int columns, int start){
        // �����Ҵ�ӡһ��
        for(int i = start; i < columns - start; i++)
            list.add(matrix[start][i]);
        // ���ϵ��´�ӡһ��
        for(int j = start + 1; j < rows - start; j++)
            list.add(matrix[j][columns - start - 1]);
        // ���ҵ����ӡһ��
        for(int m = columns - start - 2; m >= start && rows - start - 1 > start; m--)
            list.add(matrix[rows - start - 1][m]);
        // ���µ��ϴ�ӡһ��
        for(int n = rows - start - 2; n >= start + 1 && columns - start - 1 > start; n--)
            list.add(matrix[n][start]);
    }
}