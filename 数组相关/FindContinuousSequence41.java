import java.util.ArrayList;
/**
 * ��Ŀ����:������к�ΪS��������������
 
 * ��˫ָ����ʵ�֣���ʼ��left = 1��right=2��С�ڵĻ�������ƶ�right����Ļ�������ƶ�left
 * ��������������˵���ݹ����������left < (s+1)/2
   ��������������sum
 */
public class FindContinuousSequence41 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (sum <= 2) {
            return list;
        }
        int left = 1;
        int right = 2;
        while (left < (sum + 1) / 2) {
            ArrayList<Integer> seq = new ArrayList<Integer>();
            int sumTwo = 0;
            //����������sumֵ
            for (int i = left; i <= right; i++) {
                sumTwo += i;
            }
            if (sumTwo < sum) {
                right++;
            } else if (sumTwo > sum) {
                left++;
            } else {
                // ��ȵĻ�������һ���⣬Ȼ�����left��right
                for (int i = left; i <= right; i++) {
                    seq.add(i);
                }
                list.add(seq);
                left++;
                right++;
            }
        }
        return list;
    }
}