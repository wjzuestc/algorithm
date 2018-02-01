/**
 * �����������ԣ���ָ��������˳��ͳ��ǰһ�����ִ��ں�һ�����ֵ�����ԡ�
   ���ֽⷨ��1. O(n^2)�ⷨ������ɨ�裬��ͷ��β��������iλ�õ����֣��ͱ����ж�������û�б���С��
            2. O(nlogn)�ⷨ���鲢�����ȷָ�����飬ͳ�������������ԣ�������Ȼ��ͳ����һ��������ԣ�ֱ�����   �˷���Ҫ�ռ临�Ӷ�O(n)
 */
public class InversePairs36 {
    
    private int pairsCount = 0;
    
    public int inversePairs(int [] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        
        inversePairsCore(array, 0, array.length - 1);
        return pairsCount % 1000000007;
    }
    
    //�ָ�����
     public void inversePairsCore(int [] array, int start, int end) {
         if (end <= start) {
             return;
         }
         int mid = start + (end - start) / 2;
         inversePairsCore(array, start, mid);
         inversePairsCore(array, mid + 1, end);
         
         meger(array, start, mid, end);
         
     }
    
    /**
     * �ϲ�����
     */
    public void meger(int [] array, int start, int mid, int end) {
        //��������
        int[] copy = new int[end - start + 1];
        int left = mid;
        int right = end;
        int index = end - start;
        while (left >= start && right >= mid + 1) {
            if (array[right] > array[left]) {
                copy[index--] = array[right];
                right--;
            } else {
                copy[index--] = array[left];
                //��ֹpairsCount���󣬲���Խ��
                if (pairsCount >= 1000000007) {
                    pairsCount %= 1000000007;
                }
                //Ҫע�ⳤ�ȵ�  ��-ǰ+1
                pairsCount += (right - (mid + 1)) + 1;
                left--;
            }
        }
        while (left >= start) {
            copy[index--] = array[left];
            left--;
        }
        while (right >= mid + 1) {
            copy[index--] = array[right];
            right--;
        }
        //�鲢����
        for(int i = 0; i < copy.length; i++) {
            array[start++] = copy[i];
        }
    }
}