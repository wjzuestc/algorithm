/**
 *��Ŀ����:����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
           ���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 */
public class Solution {
    public void reOrderArray(int [] array) {
        if (array == null || array.length <= 0) {
            return;
        }
        int[] arr = new int[array.length];
        int k = 0; 
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                arr[k++] = array[i];
            }  
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) != 1) {
                arr[k++] = array[i];
            }  
        }
        for (int i = 0; i < array.length; i++) {
             array[i] = arr[i];
        }
    }
}