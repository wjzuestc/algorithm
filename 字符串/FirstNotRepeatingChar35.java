/**
 ��Ŀ����:��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
 * ���ֽ��1. ����hash��ʵ��  O(1) �Ŀռ临�Ӷ�  O(n)ʱ�临�Ӷ�
            2. �������ң�����ҪO(n^2)
 */
public class FirstNotRepeatingChar35 {
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        int[] hash = new int[256];
        // ��ʼ��hash��
        for (int i = 0; i < str.length(); i++) {
			hash[str.charAt(i)] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
			if (hash[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}