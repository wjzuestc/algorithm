import java.util.*;
/**
 * 题目描述:
		如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
		那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 解决此问题有多种方法：1. 利用无序数组，实现O(1)插入，O(n)获取  partition函数获取
                      2. 插入排序实现有序插入O(n)，O(1)实现获取
                      3. AVL树实现O(logn)
                      4. 两个堆，一个最小堆，一个最大堆，把数据分为两部分，从而实现O(logn)插入，O(1)获取
 */
public class MedianData64 {
    //默认是小顶堆   存的是数据流的后半部分
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //自定义排序规则，实现大顶堆  实际上存的是数据流的前半部分
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
       @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    //记录总数  奇数放在大顶堆（前半部分），但要经过小顶堆的判断，，偶数个放在小顶堆  且要经过大顶堆判断
    private int count = 0;

    public void Insert(Integer num) {
        count++;
        // 奇数放在最大堆，且确保最大堆放的是数据流的前半部分（即：排序的小的部分）
        if ((count & 1) == 1) {
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        } else {
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
    }

    public Double GetMedian() {
         if ((count & 1) == 1) {
             return maxHeap.peek() * 1.0;
         } else {
             return (maxHeap.peek() + minHeap.peek()) / 2.0;
         }
    }


}