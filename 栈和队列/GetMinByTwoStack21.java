import java.util.LinkedList;
/**
 * 题目描述:定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 
 * 用两个栈来实现min，其思想是：要不就在push的时候判断进行做工作，要不然就在pop时进行相关判断工作
 * 用剑指offer的思路来做，即在push的时候进行相关处理工作
 */
public class GetMinByTwoStack21 {
	LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> minStack = new LinkedList<>();
    
    /**
     * push的逻辑相当于，针对stack中的每个元素都在minStack中填了对应的最小值，所以在pop时可以直接两个都出栈
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