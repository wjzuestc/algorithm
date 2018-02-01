/**
 * 题目描述:把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。 
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber34 {
    //超时：因为算了太多不是丑数的数了
    
    /*
    public int GetUglyNumber_Solution(int index) {
        if (index <=0) {
            return -1;
        }
		int uglyNum = 0;
        int num = 0;
        while (uglyNum < index) {
             num++;
            if (getUglyNum(num)) {
                uglyNum++;
            }
        }
        return num;
    }
    
    public boolean getUglyNum(int num) {
        while ((num & 0x1) == 0) {
            num >>=1;
        }
        while (num % 3 == 0) {
            num /=3;
        }
        while (num % 5 == 0) {
            num /=5;
        }
        if (num == 1) {
            return true;
        }
        return false;
    } */
    
    
    // 根据前面的丑数值，来算后边的、
     public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
       		return 0;
   	    }
        int[] result = new int[index];
        result[0] = 1;
        // 我们按顺序不断加入丑数，只需要比较 *2 *3 *5  对应的最小丑数  乘出来的丑数即可
        int dis2 = 0;   // 代表*2 的最小丑数对应的索引
        int dis3 = 0;   // 代表*3 的最小丑数对应的索引
        int dis5 = 0;   // 代表*5 的最小丑数对应的索引
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[dis2] * 2 , Math.min(result[dis3] * 3, result[dis5] * 5));
            // 说明新加入的丑数是由 *2 所对应的丑数加入的，所以要顺序更新*2的最小丑数值，即更新dis2索引
            if (result[i] == result[dis2] * 2) {
                dis2++;
            }
            if (result[i] == result[dis3] * 3) {
                dis3++;
            }
           if (result[i] == result[dis5] * 5) {
                dis5++;
            }
        }
        return result[index-1];
     }
   

}