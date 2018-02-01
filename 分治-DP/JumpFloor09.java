/**
 * 题目描述:一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 斐波那契的变形
 */
public class JumpFloor09 {
    public int jumpFloor(int target) {
	/*	
    	此解法有大量的子问题的重复计算。
    	if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
     */
	    if(target <= 0) {
            return -1;
        }
        if (target <= 2) {
            return target;
        }
        int num2 = 1;
        int num1 = 2;  // 这是指n-1那个项，注意其意义
        // f(n) = f(n-1) + f(n-2)
        for (int i = 3; i <= target; i++) {
            int temp = num1;
            num1 = num1 + num2;
            num2 = temp;
        }
        return num1;
	}
}