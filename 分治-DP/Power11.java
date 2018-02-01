/**
 * ��Ŀ����:����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * �������Ҫ���ǵĺࣺܶ1. baseΪ0��exponentΪ0ʱ�Ĵ���
 				      2. exponent��������
 				      3. double������ж�
                      4. �����㷨��ʵ��
 */
public class Power11 {
    public double power(double base, int exponent) {
        if (isEqual(base, 0.0) && isEqual(exponent, 0.0)) {
            throw new ArithmeticException(); // 0��0�η������������
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
        // ����Ǹ����Ļ��������䵹��
        if (isNative) {
            return 1 / result;
        }
        return result;
    }
    
    /**
     * ���εݹ��������η���Ҫ����һ���Ϳ�����ż��Ӱ��
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
     
    // �����������
    public boolean isEqual(double num1, double num2) {
        if (Math.abs(num1 - num2) < 0.000001) {
            return true;
        }
        return false;
    }
}