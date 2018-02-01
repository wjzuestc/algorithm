/**
 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� 
 * ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
 * Ҫע����ֱ߽�͸������
 */

public class StrToInt49 {
    public int strToInt(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        boolean nagative = false;
        int i = 0;
        int limit = Integer.MAX_VALUE;
        char first = str.charAt(0);
        if (first < '0') {
            if (first == '-') {
                limit = Integer.MIN_VALUE;
                nagative = true;
            } else if (first != '+') {
                return 0;
            }
            if (str.length() == 1) {
                return 0;
            }
            i++;   //ע��i������
        }
        int result = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                result *= 10;
                //��tmҪע���ˣ�2147483648 - 1 ��Ϊ 2147483647  ���൱�� ����������ͨ���˾����ж�
                //��ֹԽ�磺result+num
                if (result > limit - num) {    
                    return 0;
                }
                result += num;
            } else {
                return 0;
            }
        }
        return nagative? -result : result;
    }
}