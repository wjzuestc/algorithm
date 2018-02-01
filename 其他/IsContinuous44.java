import java.util.*;
/**
 * �жԿ϶�����˳��
   ������������ÿ��Ա���С����ȫ������
 */
public class IsContinuous44 {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return false;
        } 
        // ����
        Arrays.sort(numbers);
        int kingNum = 0;
        int cap = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                kingNum++;
                continue;
            }
            if (numbers[i] == numbers[i + 1]) {
                return false;
            }
            cap += numbers[i+1] - numbers[i] - 1;
        }
        if (cap <= kingNum) {
            return true;
        }
        return false;
    }
}