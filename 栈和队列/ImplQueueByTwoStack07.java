import java.util.LinkedList;

/**
 * 两个栈来实现：stack1：负责插入 ：正常插入
 *             stack2：负责pop ： 要进行相关判断
 * 其中有代码细节注意一下：1.返回值是int，如果不用泛型的话，是Object，需要强转
 *                      2.集合判断长度是size函数，老是搞成length()--这是字符串的
 *                      3.异常操作错误处理时，抛异常   异常包在lang包中
 * 两个队列实现栈：注意这个和上边的实现思想是不一样的，是根据其offer，poll操作来实现的
 */
public class ImplQueueByTwoStack07 {
    LinkedList<Integer> stack1 = new LinkedList<>(); //负责插入
    LinkedList<Integer> stack2 = new LinkedList<>(); //负责弹出
    
    public void push(int node) {
		stack1.push(node);
    }
    
    public int pop() {
        if (stack2.size() > 0) {
            return stack2.pop();
        }
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        // 如果是空，就抛异常
        if (stack2.size() < 0) {
            throw new NullPointerException();
        } 
        return stack2.pop();
    }
}