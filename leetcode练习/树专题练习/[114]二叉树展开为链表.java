/*
给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
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
    private TreeNode p = null;
    public void flatten(TreeNode root) {
        //先遍历右子树，再遍历左子树，最后是根节点，反过来就是一个根左右的链表
        if(root==null) return ;
        flatten(root.right);
        flatten(root.left);
        //类似与遍历二叉树中的[右-左-根]顺序
        root.right = p;  //p为链表的表头
        root.left = null;
        p = root;
    }
}