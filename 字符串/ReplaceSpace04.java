/**
 *��Ŀ����:��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
  ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
  
 * �ж���ʵ�֣�1. O(n^2) ��ǰ����ɨ������Ų
              2. �Ӻ���ǰɨ��ʵ��һ�α����Ϳ���ʵ��
 */
public class ReplaceSpace04 {
    public String replaceSpace(StringBuffer str) {
    	if (str == null || str.length() <= 0) {
            return "";
        }
        // ͳ�ƿո���
        int blankNum = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                blankNum += 1;
            }
        }
        // �����������㹻Ԫ�ص�ֵ
        char[] strChar = new char[len + 2 * blankNum];
        int k = len + 2 * blankNum - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                strChar[k--] = '0';
                strChar[k--] = '2';
                strChar[k--] = '%';
            } else {
                strChar[k--] = str.charAt(i);
            }
        }
        return new String(strChar);
    }
}