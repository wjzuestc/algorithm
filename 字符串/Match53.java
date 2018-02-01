/**
 * ����Ĺؼ��ǣ������ķ���������Լ�Ҫ������ָ�룬�ڶ���ָ�����ж���һ��ģʽ�ַ��Ƿ���*��'.'���жϺܼ�
 * �ַ���λ��ָ��s  ƥ�䴮����ָ��  index1��index2
 * 1. ���index2���ַ�����*
       1.1 index1 == s �� index2='.' ����true;
       1.2 index1 �� s ���ַ����ȣ��򷵻�false
   2. ���index2���ַ���*
       2.1 ��index1 �� s ���ַ����ȣ���ƥ�䴮ǰ������λ�ã����Ե�index1��index2���ٴν��еݹ�ƥ��
       2.2 ��index1 == s����Ҫ��3���������������
            2.2.1 �ַ���s������ƥ�䴮ǰ������λ�ã����Ե�index1��index2���ٴν��еݹ�ƥ��
            2.2.2 �ַ���s+1��ƥ�䴮ǰ������λ�ã��ٴν��еݹ�ƥ��  ����ʵ��һ���͵������ǿ��Ժ�һ��ģ�Ч����һ���ģ�
            2.2.3 �ַ���s+1��ƥ�䴮λ�ò��䣬�������еݹ�ƥ��
 */
public class Match53 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }
     public boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
         // �������ͷ�ˣ��򷵻�true
         if (strIndex == str.length && patternIndex == pattern.length) {
             return true;
         }
         // ���pattern�ȵ�ͷ�ˣ�˵����ƥ�䣬����false
         if (strIndex != str.length && patternIndex == pattern.length) {
             return false;
         }
         // ����ڶ����ַ��� *
         int patternIndex2 = patternIndex + 1;
         if (patternIndex2 < pattern.length && pattern[patternIndex2] == '*') {
             if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) 
                 || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                 return matchCore(str, pattern, strIndex, patternIndex + 2)
                     || matchCore(str, pattern, strIndex + 1, patternIndex + 2)
                     || matchCore(str, pattern, strIndex + 1, patternIndex);
             } else {
                 return matchCore(str, pattern, strIndex, patternIndex + 2);
             }
         }
        //ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) 
            || (strIndex != str.length && pattern[patternIndex] == '.')) {
            return matchCore(str, pattern, strIndex + 1, patternIndex + 1);
        }
        return false;
     }
}