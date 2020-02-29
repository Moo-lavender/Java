/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
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
    private LinkedList<List<Integer>> list = new LinkedList<>();
    private ArrayList<Integer> inner = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return list;
        sum -= root.val;
        inner.add(root.val);
        if(sum == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(inner));
        }
        if(root.left != null) pathSum(root.left,sum);
        if(root.right != null) pathSum(root.right,sum);
        inner.remove(inner.size() - 1);
        return list;
    }
}