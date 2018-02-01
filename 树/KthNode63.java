/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
/**
 * ��Ŀ������
   ����һ�Ŷ��������������ҳ����еĵ�k��Ľ�㡣���磬 5 / \ 3 7 /\ /\ 2 4 6 8 �У��������ֵ��С˳�����������ֵΪ4��
 * �����������k��Ԫ�ؼ��� 1. ��һ������������������
                        2. �ݹ�ʵ�֣���Ҫ��һ��ȫ�ֱ����������������Ŀ
 */
public class KthNode63 {
    private int kthNum = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        kthNum = k;
        return KthNodeCore(pRoot);
    }
    
     //���������ʵ�ֿ϶��������м���߼�    
     TreeNode KthNodeCore(TreeNode pRoot) {
         // �о�����ڱ���ʱд if(pRoot.left != null){}  ��ô�Ϳ��Բ�д����߽�
         // ���ǣ��������ѭ���б������͵�д if(pRoot.left != null) ���ܽ�����һ������
         //if (pRoot == null) {
           //  return null;
         //}
         TreeNode target = null;
         // ������
         if(pRoot.left!=null) {
             target = KthNodeCore(pRoot.left);
         }
         // ������û�ҵ�
         if (target == null) {
             if (kthNum == 1) {
                 target = pRoot;
             }
             kthNum--;
         }
         // ��ǰ�ڵ�Ҳ����
         if (target == null && pRoot.right != null) {
             target = KthNodeCore(pRoot.right);
         }
         return target;
     }
}






