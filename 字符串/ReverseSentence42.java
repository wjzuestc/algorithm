/**
 * ��Ŀ���������磬��student. a am I����ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.��
 * ���η�ת�������巭תһ�Σ��ٷֵ��ʷ�ת   �����ȵ��ʷ�ת�������巭ת
 */
public class ReverseSentence42 {
    public String ReverseSentence(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        char[] strChar = str.toCharArray();
        int len = strChar.length;
        ReverseString(strChar, 0, len - 1);
        int index = 0;
        for (int i = 0; i < len; i++) {
            // ���ֻ��һ���ո�
            if (strChar[i] == ' ' && index < i) {
                ReverseString(strChar, index, i - 1);
                index = i + 1;
            }
        }
        // ��ת���һ���ַ�
        ReverseString(strChar, index, len - 1);  
        return new String(strChar);
    }
    
    /**
     * ��תһ���ַ���   ǰ�����   
     */
    public void ReverseString(char[] strChar, int start, int end) {
        // ��һ�����������º��Ҫ�滻��ֵ
        int endIndex = end;
        for (int i = start; i <= (start + end) / 2; i++) {
            char temp = strChar[i];
            strChar[i] = strChar[endIndex];
            strChar[endIndex] = temp;
            endIndex--;
        }
    }
}