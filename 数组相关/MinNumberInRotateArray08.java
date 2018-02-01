import java.util.ArrayList;
/**
 * ��ת�����е���С����
 * ����������ı��Σ����������Ƿ�����ö�����ʵ��
 * left����ǰ�벿�֣�right���ں�ߵĲ��֣��������������leftָ��ǰ�������һ����rightָ��󲿷���ǰһ��
 */
public class MinNumberInRotateArray08 {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        // ע�⣺��λ������ǵ����ȼ���С�������������
        int mid = (left + (right - left)) >> 1;
        if (array[left] == array[right] && array[left] == array[mid]) {
            return minNumberInSequenceArray(array);
        }
        while ((right - left) != 1) {
            mid = left + (right - left) / 2;
            // Ҫ�������ظ�Ԫ�ص�����������Ǵ��ڵ���
            if (array[mid] >= array[left]) {
                left = mid;
            } 
            if (array[mid] < array[left]) {
                right = mid;
            }
        }
        return array[right];
    }
    
    // �������ȣ������˳�����
    public int minNumberInSequenceArray(int[] nums) {
        int minNum = nums[0];
        for (int i = 0; i < nums.length; i++) {
			if (minNum > nums[i]) {
                minNum = nums[i];
            }            
        }
        return minNum;
    }
}