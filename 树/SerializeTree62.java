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
 * ���л��ͷ����л���
 * 1. ��������ǰ�������Ȼ��ʵ�ַ����л�
   2. ǰ����������ǽ�null�������������ʾ���Ӷ�ʵ�ַ����л� �ݹ�ʵ��
 */
public class SerializeTree62 {
    // index������¼�ַ������л���λ��
    int index = -1;
    // ǰ�������null��'#'�ַ���ʾ�����ڵ���','�ŷָ�
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val);
        sb.append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    //�����л����������л��Ĺ���
    TreeNode Deserialize(String str) {
        index++;
        TreeNode root = null;
        String[] splits = str.split(",");
        // ����ж���ʵ�ǵݹ��˳�����
        if (!"#".equals(splits[index])) {
            root = new TreeNode(Integer.valueOf(splits[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }
}












