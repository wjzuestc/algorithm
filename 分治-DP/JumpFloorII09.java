/**
 * 题目描述:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
   求该青蛙跳上一个n级的台阶总共有多少种跳法。
   
 * 数学归纳法： 总共有2^(n-1)种
 */
public class JumpFloorII09 {
    public int jumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        }
        return (int)Math.pow(2, target - 1);
    }
}