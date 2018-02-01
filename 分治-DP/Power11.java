/**
 * 题目描述:给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 这个问题要考虑的很多：1. base为0，exponent为0时的处理
 				      2. exponent正负处理
 				      3. double的相等判断
                      4. 分治算法的实现
 */
public class Power11 {
    public double power(double base, int exponent) {
        if (isEqual(base, 0.0) && isEqual(exponent, 0.0)) {
            throw new ArithmeticException(); // 0的0次方，是无意义的
        }
        if (exponent == 0) {
            return 1;
        }
        boolean isNative = false;
        if (exponent < 0){
            isNative = true;
        }
        int exponentNum = Math.abs(exponent);
        double result = numPower(base, exponentNum);
        // 如果是负数的话，是求其倒数
        if (isNative) {
            return 1 / result;
        }
        return result;
    }
    
    /**
     * 分治递归求整数次方，要在这一步就考虑奇偶的影响
     */ 
     public double numPower(double base, int exponent) {
         if (exponent == 1) {
             return base;
         }
         double res =  numPower(base, exponent / 2);
         res *= res;
         if ((exponent & 1) == 1) {
            res *= base;
         }
         return res;
     }
     
    // 浮点数判相等
    public boolean isEqual(double num1, double num2) {
        if (Math.abs(num1 - num2) < 0.000001) {
            return true;
        }
        return false;
    }
}