import java.util.*;
/**
 * ��Ŀ����:
		��εõ�һ���������е���λ����������������ж�����������ֵ��
		��ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * ����������ж��ַ�����1. �����������飬ʵ��O(1)���룬O(n)��ȡ  partition������ȡ
                      2. ��������ʵ���������O(n)��O(1)ʵ�ֻ�ȡ
                      3. AVL��ʵ��O(logn)
                      4. �����ѣ�һ����С�ѣ�һ�����ѣ������ݷ�Ϊ�����֣��Ӷ�ʵ��O(logn)���룬O(1)��ȡ
 */
public class MedianData64 {
    //Ĭ����С����   ������������ĺ�벿��
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //�Զ����������ʵ�ִ󶥶�  ʵ���ϴ������������ǰ�벿��
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
       @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    //��¼����  �������ڴ󶥶ѣ�ǰ�벿�֣�����Ҫ����С���ѵ��жϣ���ż��������С����  ��Ҫ�����󶥶��ж�
    private int count = 0;

    public void Insert(Integer num) {
        count++;
        // �����������ѣ���ȷ�����ѷŵ�����������ǰ�벿�֣����������С�Ĳ��֣�
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