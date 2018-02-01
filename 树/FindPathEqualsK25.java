import java.util.ArrayList;
/**
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
 * ��Ŀ����:����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����
           ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
		   
 * �ݹ���һ�����ݵĹ��̣���ʵ�ݹ�ĵ���Ҳ��һ��ѹջ�ͳ�ջ�Ĺ���
 * ����ǰ�����������·���������ݣ���ʵҲ��һ��DFS�Ĺ��̣�
 */
public class FindPathEqualsK25 {
    //����Ϊȫ�ֱ���
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) {
			return listAll;
		}
        list.add(root.val);
        target -= root.val;
        //����Ҷ�ڵ���ֵ���
        if(target == 0 && root.left == null && root.right == null) 
            listAll.add(new ArrayList<Integer>(list));
        //ǰ�����  ��Ϊ��ȫ�ֱ��������Է���ֵ��ûʲô���õ�
        //�Ӻ�۽Ƕ�����  ������ �ݹ����һ�����ݹ���
        FindPath(root.left, target);
        FindPath(root.right, target);
        //���ص����ڵ�ǰ��·��Ҫɾ����ǰ�ڵ�
        list.remove(list.size()-1);
        return listAll;
    }
}