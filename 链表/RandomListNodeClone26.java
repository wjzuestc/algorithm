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
 * �����⣬�����ֽ������
   1. �������뵽�ģ�O(n^2)�ⷨ����һ��������nextָ�룬�ڶ�������ÿһ���ڵ㣬����ҪO(n)��ʱ��������randomָ���λ��
   2. ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(n) ���Կ��������ʱ����Ƕ���randomָ���ȷ�������Կ�������һ��hash��
      <n,n'> ����ԭ�����븴�������ӳ�䣬���Զ���n��randomָ��ָ��s����������O(1)��ʱ�������n'��Ӧ��randomָ��s'   
   3. ʱ�临�Ӷ�O(n) �ռ临�Ӷ�O(1)�Ľⷨ��������  ��һ�� ����next n1->n1'->n2->n2'....
                                               �ڶ��� ����random  n1->s1  ��Ӧ n1'->s1.next
                                               ������ �������Ϊ��������
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
    
    //��һ������������ next
    public void connectNext(RandomListNode pHead) {
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode copyNode = new RandomListNode(node.label);
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }
    }
    
    //�ڶ�������������randomָ��
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
    
    //���������������
    public RandomListNode splitList(RandomListNode pHead) {
        RandomListNode node = pHead;
        RandomListNode copyHead = pHead.next;
        RandomListNode copyNode = copyHead;
        
        while (node != null) {
            node.next = copyNode.next;
            node = node.next;
            //���node�Ѿ������һ���ڵ��ˣ�����node.nextָ����null��null.next�ͻᱨ��ָ�룬
            //����Ҫ��һ���жϣ�������һ���ڵ�
            if (node != null) {
                copyNode.next = node.next;
                copyNode = copyNode.next;
            } 
        }
        return copyHead;
    }
}

















