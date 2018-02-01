import java.util.*;
/**
 *题目描述:输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 实现：1. O(n)用partition实现，寻找index = k的位置。
        2. 用最大堆实现，时间复杂度为O(nlogk) 适用于海量数据处理
        
   其他方法：排序O(nlogn)  
           线性查找：找最小的，然后与第一个交换，然后再接着查找
 */
public class GetLeastNumbers30 {
    
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        
        // 使用Partition函数实现  会改变原数组  时间复杂度O(n)
        return getLeastNumbersByPartition(input, k);
        
        // 用最大堆实现  适用于海量数据处理，且不会改变原数组   时间复杂度O(nlogk) 空间复杂度 O(logk)
        //return getLeastNumbersByMaxHeap(input, k);
        
    }
    
    // 利用快排的partition实现   会改变原数组   原理是当partition返回的index = k，代表，前k个就是最小的数字
    public ArrayList<Integer> getLeastNumbersByPartition(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || input.length <= 0 || k > input.length || k <= 0) {
            return list; 
        }
        int index = partition(input, 0, input.length - 1);
        // 直到找到k-1的位置为止
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
    
    // 快排的partition函数  
    public int partition(int[] input, int start, int end) {
        if (input == null || input.length <= 0 || start > end) {
            return -1;
        }
        int indexNum = input[start];
        int left = start;
        int right = end;
        // 保证left == right时跳出循环
        while (left < right) {
            // 保证前left个严格小于其index
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
        // 最大堆来实现
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < input.length; i++) {
            // 先初始化最大堆
            if (maxHeap.size() < k) {
                maxHeap.offer(input[i]);
                continue;
            }
            // 判断置换元素
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