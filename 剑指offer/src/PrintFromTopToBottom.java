import java.util.*;
//从上到下打印二叉树
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	if(root == null)return result;
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	queue.offer(root);
	while(!queue.isEmpty()){
		TreeNode temp = queue.poll();
		result.add(temp.val);
		if(temp.left != null)queue.offer(temp.left);
		if(temp.right != null)queue.offer(temp.right);
	}
	return result;
}
