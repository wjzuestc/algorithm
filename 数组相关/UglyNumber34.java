/**
 * ��Ŀ����:��ֻ��������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ����������7�� 
 * ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 */
public class UglyNumber34 {
    //��ʱ����Ϊ����̫�಻�ǳ���������
    
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
    
    
    // ����ǰ��ĳ���ֵ�������ߵġ�
     public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
       		return 0;
   	    }
        int[] result = new int[index];
        result[0] = 1;
        // ���ǰ�˳�򲻶ϼ��������ֻ��Ҫ�Ƚ� *2 *3 *5  ��Ӧ����С����  �˳����ĳ�������
        int dis2 = 0;   // ����*2 ����С������Ӧ������
        int dis3 = 0;   // ����*3 ����С������Ӧ������
        int dis5 = 0;   // ����*5 ����С������Ӧ������
        for (int i = 1; i < index; i++) {
            result[i] = Math.min(result[dis2] * 2 , Math.min(result[dis3] * 3, result[dis5] * 5));
            // ˵���¼���ĳ������� *2 ����Ӧ�ĳ�������ģ�����Ҫ˳�����*2����С����ֵ��������dis2����
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