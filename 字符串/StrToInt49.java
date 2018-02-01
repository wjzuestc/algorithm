/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 
 * 数值为0或者字符串不是一个合法的数值则返回0
 * 要注意各种边界和各种情况
 */

public class StrToInt49 {
    public int strToInt(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        boolean nagative = false;
        int i = 0;
        int limit = Integer.MAX_VALUE;
        char first = str.charAt(0);
        if (first < '0') {
            if (first == '-') {
                limit = Integer.MIN_VALUE;
                nagative = true;
            } else if (first != '+') {
                return 0;
            }
            if (str.length() == 1) {
                return 0;
            }
            i++;   //注意i的妙用
        }
        int result = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                result *= 10;
                //这tm要注意了，2147483648 - 1 变为 2147483647  这相当于 正父都可以通过此句子判断
                //防止越界：result+num
                if (result > limit - num) {    
                    return 0;
                }
                result += num;
            } else {
                return 0;
            }
        }
        return nagative? -result : result;
    }
}