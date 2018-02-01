/**
 * 题目：对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 翻转字符串的变形：可以把待翻转的字符看做一个字符串，后边的看做一个
                  两步翻转来解决，先翻转整体，再每个翻转，或者先翻转部门，再翻转整体，效果一样
 */
public class LeftRotateString42 {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() <= 0 || n > str.length()) {
            return "";
        }
        char[] strChar = str.toCharArray();
        int len = str.length();
        // 先翻转部分
        for(int i = 0; i < n / 2; i++) {
            swapChar(strChar, i, n - 1 - i);
        }
        int k = 0;
        for(int i = n; i < (len + n) / 2; i++) {
            swapChar(strChar, i, len - 1 -k);
            k++;
        }
        // 翻转整体
        for(int i = 0; i < len / 2; i++) {
            swapChar(strChar, i, len - 1 - i);
        }
        return new String(strChar);
    }
    
    // 交换两个字符
    public void swapChar(char[] strChar, int char1, int char2) {
            char temp = strChar[char1];
            strChar[char1] = strChar[char2];
            strChar[char2] = temp;
    }
}