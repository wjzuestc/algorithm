import java.util.*;
/**
 *��Ŀ����:����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 * ʵ�֣�1. O(n)��partitionʵ�֣�Ѱ��index = k��λ�á�
        2. ������ʵ�֣�ʱ�临�Ӷ�ΪO(nlogk) �����ں������ݴ���
        
   ��������������O(nlogn)  
           ���Բ��ң�����С�ģ�Ȼ�����һ��������Ȼ���ٽ��Ų���
 */
public class GetLeastNumbers30 {
    
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        
        // ʹ��Partition����ʵ��  ��ı�ԭ����  ʱ�临�Ӷ�O(n)
        return getLeastNumbersByPartition(input, k);
        
        // ������ʵ��  �����ں������ݴ����Ҳ���ı�ԭ����   ʱ�临�Ӷ�O(nlogk) �ռ临�Ӷ� O(logk)
        //return getLeastNumbersByMaxHeap(input, k);
        
    }
    
    // ���ÿ��ŵ�partitionʵ��   ��ı�ԭ����   ԭ���ǵ�partition���ص�index = k������ǰk��������С������
    public ArrayList<Integer> getLeastNumbersByPartition(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length <= 0 || k > input.length || k <= 0) {
            return list; 
        }
        int index = partition(input, 0, input.length - 1);
        // ֱ���ҵ�k-1��λ��Ϊֹ
        while (index != k - 1) {
            if (index > k - 1) {
                index = partition(input, 0, index - 1);
            } 
            if (index < k - 1) {
                index = partition(input, index + 1, input.length - 1);
            }
        }
        
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
    
    // ���ŵ�partition����  
    public int partition(int[] input, int start, int end) {
        if (input == null || input.length <= 0 || start > end) {
            return -1;
        }
        int indexNum = input[start];
        int left = start;
        int right = end;
        // ��֤left == rightʱ����ѭ��
        while (left < right) {
            // ��֤ǰleft���ϸ�С����index
            while (left < right && input[right] >= indexNum) {
                right--;
            }
            if (left < right) {
                input[left] = input[right];
                left++;
            }
            while (left < right && input[left] < indexNum) {
                left++;
            }
            if (left < right) {
                input[right] = input[left];
                right--;
            }
        }
        input[left] = indexNum;
        return left;
    }
    
    
    public ArrayList<Integer> getLeastNumbersByMaxHeap(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length <= 0 || k > input.length || k <= 0) {
            return list; 
        }
        // ������ʵ��
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < input.length; i++) {
            // �ȳ�ʼ������
            if (maxHeap.size() < k) {
                maxHeap.offer(input[i]);
                continue;
            }
            // �ж��û�Ԫ��
            if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
                continue;
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(maxHeap.poll());
        }
        return list;
    } 
}