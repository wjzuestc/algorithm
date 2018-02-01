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
 * 题目描述:输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
           路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
		   
 * 递归是一个回溯的过程，其实递归的调用也是一个压栈和出栈的过程
 * 采用前序遍历，查找路径，并回溯（其实也是一个DFS的过程）
 */
public class FindPathEqualsK25 {
    //声明为全局变量
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) {
			return listAll;
		}
        list.add(root.val);
        target -= root.val;
        //到达叶节点且值相等
        if(target == 0 && root.left == null && root.right == null) 
            listAll.add(new ArrayList<Integer>(list));
        //前序遍历  因为是全局变量，所以返回值是没什么卵用的
        //从宏观角度来看  中左右 递归就是一个回溯过程
        FindPath(root.left, target);
        FindPath(root.right, target);
        //返回到父节点前，路径要删除当前节点
        list.remove(list.size()-1);
        return listAll;
    }
}