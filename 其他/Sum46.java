/**
 * 题目描述:求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 
 * 可用构造函数来实现，构造n个对象完成共享变量的相加
 * 这里有几个小点：静态变量可以被非静态方法调用，而非静态变量不可被静态方法调用。。。静态方法和静态变量都是属于类的，所以对象也可以调用
 * 
 *
 * 这里可以用递归实现，并没有说不能用递归  n + f(n-1);
 */
public class Sum46 {
  /**
    private static int sum = 0;
    private static int num = 0;
    
    public Solution() {
        num++;
        sum += num;
    }
    public int Sum_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        Solution[] res = new Solution[n]; // 这实际上没有创建对象，只是一个数组
        return sum;
    }
   */
    //上边用构造函数不可以，不知道为何。。。
     public int Sum_Solution(int n) {
         if (n == 0) {
             return 0;
         }
         return n + Sum_Solution(n - 1);
     }
}