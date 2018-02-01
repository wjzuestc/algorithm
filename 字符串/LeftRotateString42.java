/**
 * ��Ŀ������һ���������ַ�����S���������ѭ������Kλ������������
 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ��������XYZdefabc����
 * ��ת�ַ����ı��Σ����԰Ѵ���ת���ַ�����һ���ַ�������ߵĿ���һ��
                  ������ת��������ȷ�ת���壬��ÿ����ת�������ȷ�ת���ţ��ٷ�ת���壬Ч��һ��
 */
public class LeftRotateString42 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() <= 0 || n > str.length()) {
            return "";
        }
        char[] strChar = str.toCharArray();
        int len = str.length();
        // �ȷ�ת����
        for(int i = 0; i < n / 2; i++) {
            swapChar(strChar, i, n - 1 - i);
        }
        int k = 0;
        for(int i = n; i < (len + n) / 2; i++) {
            swapChar(strChar, i, len - 1 -k);
            k++;
        }
        // ��ת����
        for(int i = 0; i < len / 2; i++) {
            swapChar(strChar, i, len - 1 - i);
        }
        return new String(strChar);
    }
    
    // ���������ַ�
    public void swapChar(char[] strChar, int char1, int char2) {
            char temp = strChar[char1];
            strChar[char1] = strChar[char2];
            strChar[char2] = temp;
    }
}