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
 * 序列化和反序列化树
 * 1. 生成中序、前序遍历，然后实现反序列化
   2. 前序遍历，但是将null用特殊符号来表示，从而实现反序列化 递归实现
 */
public class SerializeTree62 {
    // index用来记录字符串序列化的位置
    int index = -1;
    // 前序遍历，null用'#'字符表示，并节点用','号分割
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
    //反序列化，按照序列化的规则
    TreeNode Deserialize(String str) {
        index++;
        TreeNode root = null;
        String[] splits = str.split(",");
        // 这个判断其实是递归退出条件
        if (!"#".equals(splits[index])) {
            root = new TreeNode(Integer.valueOf(splits[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }
}












