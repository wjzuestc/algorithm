/**
 *题目描述:请实现一个函数，将一个字符串中的空格替换成“%20”。
  例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
  
 * 有多种实现：1. O(n^2) 从前往后扫，依次挪
              2. 从后往前扫，实现一次遍历就可以实现
 */
public class ReplaceSpace04 {
    public String replaceSpace(StringBuffer str) {
    	if (str == null || str.length() <= 0) {
            return "";
        }
        // 统计空格数
        int blankNum = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                blankNum += 1;
            }
        }
        // 创建可容纳足够元素的值
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