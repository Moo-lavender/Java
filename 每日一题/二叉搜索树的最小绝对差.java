/*
530. 二叉搜索树的最小绝对差
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

 

示例：

输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
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
    private int result = Integer.MAX_VALUE;
    private TreeNode preNode = null;
    
    public int getMinimumDifference(TreeNode root) {
        //二叉查找树中，中间节点的值一定是其左右节点值的中间数，因此最小差别一定是在中间节点与左右节点之间
        //中序遍历二叉查找树，每次比较当前节点与前一节点差值的绝对值与目前result中保存的最小值的大小，将较小的保存在result中
        getMin(root);
        return result;
    }
    
    private void getMin(TreeNode root){
        if(root == null){
            return;
        }
        getMin(root.left);
        if(preNode != null)
        {
            result = Math.min(Math.abs(root.val - preNode.val), result);
        }
        preNode = root;
        getMin(root.right);
    }
}