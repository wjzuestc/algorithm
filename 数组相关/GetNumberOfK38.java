/**
 * ��Ŀ����:ͳ��һ�����������������г��ֵĴ�����
 
   hash����� ����Ҳ���� ������������϶�����  ���ְ�.
   ���ֵı��Σ������ô���k���Ǹ�����λ�� �� ����С��k ��λ��  Ȼ�����   ʱ�临�Ӷ�Ϊ O(logn)
   ��λk��һ�γ��ֵ�λ�� �� ���һ�γ��ֵ�λ��
 */
public class GetNumberOfK38 {
    public int getNumberOfK(int [] array , int k) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid1 = (left + right) >> 1;
        // �ҵ�һ��k
        while (left <= right) {
            if (array[mid1] >= k) {
                right = mid1 - 1; 
            } else {
                left = mid1 + 1;  // < left ��ʼ��ָ��С��k��  ���Ҳ��+1��õ�һ��k
            }
            
            mid1 = (left + right) >> 1;
        }
        mid1 = left;
        
        left = 0;
        right = array.length - 1;
        int mid2 = (left + right) >> 1;
        //�����һ��k
        while (left <= right) {
            if (array[mid2] > k) {
                right = mid2 - 1;   // ����k��  ������һ��k
            } else {
                left = mid2 + 1; 
            }
            
            mid2 = (left + right) >> 1;
        }
        mid2 = right;
        
        return mid2 - mid1 + 1;
    }
}