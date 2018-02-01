import java.util.LinkedList;

/**
 * ��Ŀ����:���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
   ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
   ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 */
public class VerifyIsPopOrder22 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || pushA.length <= 0 || popA == null || popA.length <= 0 || pushA.length != popA.length) {
            return false;
        }  
        LinkedList<Integer> stack = new LinkedList<>();
        int length = popA.length;
        int k = 0;
        for (int i = 0; i < length; i++) {
            // ���ж�ջ��Ԫ���Ƿ��뵯��˳��һ��
            if (!stack.isEmpty() && stack.peek() == popA[i]) {
                stack.pop();
                continue;
            }
  			while (k < length && pushA[k] != popA[i]) {
                stack.push(pushA[k]);
                k++;
            }
            // ����ѭ������ָk>=length����push�������ˣ���û�ҵ���Ҫ�ҵ�������ͷ���false
            if (k >= length) {
                return false;
            }
            // ˵������ pushA[k] == popA[i]�������ѭ���ģ�����kҪ+1
            k++;
        }
        return true;
    }
}