import java.util.*;
/**
 * ��Ŀ����:����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��

 * ͨ���Զ���������򣺽������С�����Զ���������������������С������ϼ��ɡ�
   1. �������A < B  �����ǣ�AB < BA
   2. �������⣬����Ҫ���ַ���ģ��
 */
public class PrintMinNumber33 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer num = numbers[i];
            list.add(num.toString());
        }
        //����collections������򷽷����Զ���Ƚ��������������Ĭ�ϴ�С����
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String temp1 = s1 + s2;
                String temp2 = s2 + s1;
                return temp1.compareTo(temp2);
            }
        });
        // ����С����������������ƴ�ӷ��ؼ���
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}