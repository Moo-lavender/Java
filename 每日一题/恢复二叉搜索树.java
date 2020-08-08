/*
99. 恢复二叉搜索树
二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。

示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2
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
    List<TreeNode> list = new LinkedList<>();
    List<Integer> intVal = new LinkedList<>();

    public void recoverTree(TreeNode root) {
        if(root == null) return;
        order(root);
        Collections.sort(intVal);
        for(int i = 0; i < list.size(); i ++){
           list.get(i).val = intVal.get(i);
        }
    }
    public void order (TreeNode root){
        if(root == null) return;
        order(root.left);
        list.add(root);
        intVal.add(root.val);
        order(root.right);
    }
}