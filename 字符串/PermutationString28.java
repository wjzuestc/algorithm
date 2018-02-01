import java.util.*;
/**
 * �ݹ�ʵ��   
 * 1. ��iλ�õ�ֵ��i-(len-1)��ֵ�滻
 * 2. Ȼ���ٽ���ߵİ�����һ�����ݹ����ʵ��
 */
public class PermutationString28 {
    ArrayList<String> list = new ArrayList<String>();
    //�����ֵ���洢
    Set<String> set = new TreeSet<>();
    
    public ArrayList<String> Permutation(String str) {
       if (str == null || str.length() <= 0) {
           return list;
       }
       char[] strChar = str.toCharArray();
       int len = strChar.length;
       permutationString(strChar,len, 0);
       for(String s : set) {
           list.add(s);
       }
       return list;
    }
    
    public void permutationString(char[] strChar, int len, int index) {
        if (index >= len) {
            set.add(new String(strChar));
            return;
        }
        // ע��Ҫ��i��ʼ�滻�������Ϳ��Խ���ʼ�ַ�������
        for (int i = index; i < len; i++) {
            char temp = strChar[i];
            strChar[i] = strChar[index];
            strChar[index] = temp;
            permutationString(strChar, len, index + 1);
            //ע����Ҫ�ָ���ԭ״̬  ������һ�ε���
            temp = strChar[i];
            strChar[i] = strChar[index];
            strChar[index] = temp;
        }
        return;
    }
}