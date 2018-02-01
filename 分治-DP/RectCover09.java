/**
 * 题目描述:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
            请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法.
			
 * 斐波那契的变形：f(n)竖着放：f(n-1) 横着放（则必须得放两个）：f(n-2)
 */
public class RectCover09 {
    public int rectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target <= 2) {
            return target;
        }
		int num2 = 1;
        int num1 = 2;
        for (int i = 3; i <= target; i++) {
            int temp = num1;
            num1 = num2 + num1;
            num2 = temp;
        }
        return num1;
    }
}