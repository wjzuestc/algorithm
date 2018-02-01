/**
 * 题目描述：例如，“student. a am I”。原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”
 * 两次翻转，先整体翻转一次，再分单词翻转   或者先单词翻转，再整体翻转
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
            // 如果只有一个空格
            if (strChar[i] == ' ' && index < i) {
                ReverseString(strChar, index, i - 1);
                index = i + 1;
            }
        }
        // 翻转最后一个字符
        ReverseString(strChar, index, len - 1);  
        return new String(strChar);
    }
    
    /**
     * 翻转一个字符串   前后调换   
     */
    public void ReverseString(char[] strChar, int start, int end) {
        // 用一个索引来更新后边要替换的值
        int endIndex = end;
        for (int i = start; i <= (start + end) / 2; i++) {
            char temp = strChar[i];
            strChar[i] = strChar[endIndex];
            strChar[endIndex] = temp;
            endIndex--;
        }
    }
}