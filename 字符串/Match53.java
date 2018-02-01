/**
 * 此题的关键是：清晰的分情况讨论以及要用两个指针，第二个指针来判断下一个模式字符是否是*，'.'的判断很简单
 * 字符串位置指针s  匹配串两个指针  index1，index2
 * 1. 如果index2的字符不是*
       1.1 index1 == s 或 index2='.' 返回true;
       1.2 index1 与 s 的字符不等，则返回false
   2. 如果index2的字符是*
       2.1 若index1 与 s 的字符不等，则匹配串前进两个位置，忽略掉index1和index2，再次进行递归匹配
       2.2 若index1 == s，则要分3种情况来进行讨论
            2.2.1 字符串s不动，匹配串前进两个位置，忽略掉index1和index2，再次进行递归匹配
            2.2.2 字符串s+1，匹配串前进两个位置，再次进行递归匹配  （其实这一步和第三步是可以和一起的，效果是一样的）
            2.2.3 字符串s+1，匹配串位置不变，继续进行递归匹配
 */
public class Match53 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }
     public boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
         // 如果都到头了，则返回true
         if (strIndex == str.length && patternIndex == pattern.length) {
             return true;
         }
         // 如果pattern先到头了，说明不匹配，返回false
         if (strIndex != str.length && patternIndex == pattern.length) {
             return false;
         }
         // 如果第二个字符是 *
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
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) 
            || (strIndex != str.length && pattern[patternIndex] == '.')) {
            return matchCore(str, pattern, strIndex + 1, patternIndex + 1);
        }
        return false;
     }
}