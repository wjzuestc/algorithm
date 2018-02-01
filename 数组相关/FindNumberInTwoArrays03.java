/**
 * ��Ŀ����: ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
   ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
   
 * ʵ�֣�1.�ܼ򵥡����α������ɣ�����û�����������˳���ص�
        2.�����Ͻǿ�ʼ�ң���ߴӶ����������ص㣬Ѹ���ҵ���
 */
public class FindNumberInTwoArrays03 {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length <= 0 || array[0].length <= 0) {
            return false;
        }
        // �����Ͻǿ�ʼ������һ���ж��ų�һ�л�һ��
        int rows = array.length;
        int cols = array[0].length;
        int rowNum = 0;
        int colNum = cols - 1;
        // �߽�  rowNum >= rows  colNum < 0 ��������Ч ����false
        while (rowNum < rows && colNum >= 0) {
            if (array[rowNum][colNum] == target) {
                return true;
            } else if (array[rowNum][colNum] > target) {
                colNum--;
            } else {
                rowNum++;
            }
        }
        return false;
    }
}