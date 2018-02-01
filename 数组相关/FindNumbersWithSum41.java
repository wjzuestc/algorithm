import java.util.ArrayList;
/**
 * ��Ŀ����:����һ����������������һ������S���������в������������ǵ����ǵĺ�������S��
             ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 
 * ǰ��˫ָ��
 */
public class FindNumbersWithSum41 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length <= 0) {
            return list;
        }
        int left = 0;
        int right = array.length - 1;
        int sumTwo = 0;
        int multi = 0x7ffffff;   // ��������ÿ�εĳ˻�
        while (left < right) {
            sumTwo = array[left] + array[right];
            if (sumTwo < sum) {
                left++;
            } else if (sumTwo > sum) {
                right--;
            } else {
                // ������  ����˻�С���ϴε�ֵ������и���  ���������һ�� 
                // ��һ�θ��¿϶���left++��right--��������һ���仯��sum = num1+num2�����num1�䣬��num2�϶�ҲҪ��
                if (array[left] * array[right] < multi) {
                    if (list.size() == 2) {
                        list.remove(0);
                        list.remove(1);
                    }
                    multi = array[left] * array[right];
                    list.add(array[left]);
                    list.add(array[right]);
                }
                left++;
                right--;
            }
        }
        return list;
    }
}