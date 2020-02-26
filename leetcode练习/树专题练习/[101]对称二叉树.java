/*给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	//递归解法
    public boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        return Symmetric(root.left,root.right);
        
    }
    public boolean Symmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if (left == null || right == null)return false;
        if(left.val != right.val) return false;
        return Symmetric(left.left,right.right) && Symmetric(left.right,right.left);
        
    }
	//迭代解法
	public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null) return false;
            if(node1.val != node2.val) return false;
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);

        }
        return true;
    }
	
}