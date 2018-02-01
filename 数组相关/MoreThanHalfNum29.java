import java.util.*;

/**
 * ��Ŀ����:��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * �����ж��ֽⷨ��1. O(nlogn)�ⷨ������Ȼ��ֱ���ҵ� �м�����ּ���
                 2. O(n)�ռ临�Ӷȣ�O(n)ʱ�临�ӶȽⷨ����һ��hash����ʵ��
                 3. O(n)��ʵ�֣���Partition������ʵ���ҵ�index = n / 2 
                 4. O(n)��ʵ�֣���count����������ͬ�ͼ�1������ͬ�ͼ�1����󷵻����һ����count��Ϊ1����  �����н⣬���������ַ�����
                 5. O(n)��ʵ�� ������ȥ������ȵ�   �����н⣬���������ַ�����
 */ 
public class MoreThanHalfNum29 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int count = 0;
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
                count++;
                continue;
            }
            if (num == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        // �����н⣬���������ַ�����
        if (!hasSolution(array, num)) {
            return 0;
        }
        // �������һ����count��Ϊ1����
        return num;
    }
    
    
    // �����鿴�Ƿ��н�
    public boolean hasSolution(int[] array, int num) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return true;
        }
        return false;
    }
       
    
    
}