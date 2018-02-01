/**
 题目描述:在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 多种解答：1. 利用hash表实现  O(1) 的空间复杂度  O(n)时间复杂度
            2. 挨个查找，就需要O(n^2)
 */
public class FirstNotRepeatingChar35 {
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        int[] hash = new int[256];
        // 初始化hash表
        for (int i = 0; i < str.length(); i++) {
			hash[str.charAt(i)] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
			if (hash[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}