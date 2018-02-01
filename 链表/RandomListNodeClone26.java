/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
/**
 * 此问题，有三种解决方法
   1. 最容易想到的，O(n^2)解法，第一步将复制next指针，第二步对于每一个节点，都需要O(n)的时间来查找random指针的位置
   2. 时间复杂度O(n) 空间复杂度O(n) 可以看到，最费时间的是对于random指针的确定，所以可以利用一个hash表，
      <n,n'> 保存原链表与复制链表的映射，所以对于n的random指针指向s，可以利用O(1)的时间来获得n'对应的random指针s'   
   3. 时间复杂度O(n) 空间复杂度O(1)的解法，分三步  第一步 连接next n1->n1'->n2->n2'....
                                               第二步 连接random  n1->s1  对应 n1'->s1.next
                                               第三不 拆分链表为两个链表
 */
public class RandomListNodeClone26 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        connectNext(pHead);
        connectRandom(pHead);
        return splitList(pHead);
    }
    
    //第一步：复制链表 next
    public void connectNext(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode copyNode = new RandomListNode(node.label);
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }
    }
    
    //第二步：连接链表：random指针
    public void connectRandom(RandomListNode pHead) {
        RandomListNode node = pHead;
        while(node != null) {
            RandomListNode copyNode = node.next;
            if (node.random != null) {
                copyNode.random = node.random.next;
            } 
            node = copyNode.next;
        }
    }
    
    //第三步：拆分链表
    public RandomListNode splitList(RandomListNode pHead) {
        RandomListNode node = pHead;
        RandomListNode copyHead = pHead.next;
        RandomListNode copyNode = copyHead;
        
        while (node != null) {
            node.next = copyNode.next;
            node = node.next;
            //如果node已经是最后一个节点了，所以node.next指向了null，null.next就会报空指针，
            //所以要加一个判断，解决最后一个节点
            if (node != null) {
                copyNode.next = node.next;
                copyNode = copyNode.next;
            } 
        }
        return copyHead;
    }
}

















