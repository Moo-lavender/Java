/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 首先对于这两个方法是不可以合并在一起的
 maxPathSum 返回的是遍历过整个树后的最大路径
 getMax方法是求得对于某一个节点来说,该节点与左子树和右子树最大的一条单向路径，以供它的父节点使用
		并且每次以该节点为，求得路径的根节点，比较和max的区别。
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }
    public int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0,getMax(root.left));
        int right = Math.max(0,getMax(root.right));
        int con = left + right + root.val;
        max = Math.max(con,max);
        return Math.max(left,right) + root.val; 
    }
}