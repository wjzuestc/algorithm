/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/

import java.util.ArrayList;
/**
 * 题目描述:输入一个链表，从尾到头打印链表每个节点的值。
 * 1. 利用集合容器保存一下   存在空间复杂度
   2. 利用递归实现，利用递归深度实现   递归也存在空间复杂度
   3. 翻转链表实现，如果可以改变原序列的话
 */
public class PrintListFromTailToHead05 {
    
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //如果不声明成全局变量就用返回值来实现
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (listNode == null) {
            return list;
        }
        list.addAll(printListFromTailToHead(listNode.next));
        list.add(listNode.val);
        return list;
    }
}