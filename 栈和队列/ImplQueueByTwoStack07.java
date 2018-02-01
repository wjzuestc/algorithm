import java.util.LinkedList;

/**
 * ����ջ��ʵ�֣�stack1��������� ����������
 *             stack2������pop �� Ҫ��������ж�
 * �����д���ϸ��ע��һ�£�1.����ֵ��int��������÷��͵Ļ�����Object����Ҫǿת
 *                      2.�����жϳ�����size���������Ǹ��length()--�����ַ�����
 *                      3.�쳣����������ʱ�����쳣   �쳣����lang����
 * ��������ʵ��ջ��ע��������ϱߵ�ʵ��˼���ǲ�һ���ģ��Ǹ�����offer��poll������ʵ�ֵ�
 */
public class ImplQueueByTwoStack07 {
    LinkedList<Integer> stack1 = new LinkedList<>(); //�������
    LinkedList<Integer> stack2 = new LinkedList<>(); //���𵯳�
    
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
        // ����ǿգ������쳣
        if (stack2.size() < 0) {
            throw new NullPointerException();
        } 
        return stack2.pop();
    }
}