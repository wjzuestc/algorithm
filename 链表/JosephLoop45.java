import java.util.LinkedList;
/**
 * Լɪ�����⣺1. ��������ģ�⻷
 *               2. ���ɹ���
 */
public class JosephLoop45 {
    public int LastRemaining_Solution(int n, int m) { 
        if (n <= 0 || m <= 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        // ��ʼ�����
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        // ģ��Լɪ������
        int start = 0;   // ������ʼ��
        int count = 1;   // ������¼�Ƿ�ó�����
        while(list.size() > 1 ) {
            int len = list.size();
            while(count < m) {
                count++;
                start++;
                // ����������
                if (start >= len) {
                    start = 0;
                }
            }
            list.remove(start);
            count = 1;   
            // Ҫ�ж��Ƿ���һ�����ӵ������һ����Ҫ��Ȼ���п�ָ������
            if (start == len - 1) {
                start = 0;
            }
        }
        return list.get(start);
    }
}