import java.util.LinkedList;
/**
 * ��Ŀ����:����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 
 * ������ջ��ʵ��min����˼���ǣ�Ҫ������push��ʱ���жϽ�����������Ҫ��Ȼ����popʱ��������жϹ���
 * �ý�ָoffer��˼·����������push��ʱ�������ش�����
 */
public class GetMinByTwoStack21 {
	LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();
    
    /**
     * push���߼��൱�ڣ����stack�е�ÿ��Ԫ�ض���minStack�����˶�Ӧ����Сֵ��������popʱ����ֱ����������ջ
     */
    public void push(int node) {
        stack.push(node);
        if (minStack.size() == 0 || node < minStack.peek()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    } 
    
    public void pop() {
        if (stack.size() <= 0) {
            throw new NullPointerException();
        }
		stack.pop();
        minStack.pop();
    }
    
    public int top() {
        if (stack.size() <= 0) {
            throw new NullPointerException();
        }
        return stack.peek();
    }
    
    public int min() {
        if (stack.size() <= 0) {
            throw new NullPointerException();
        }
        return minStack.peek();
    }
}