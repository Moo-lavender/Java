/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
	//递归
    public boolean isValidBST1(TreeNode root) {
        return judge(root,null,null);
    }
    public boolean judge(TreeNode node,Integer lower,Integer upper){
        if(node == null) return true;
        int val = node.val;
        
        if(lower != null && val <= lower) return false;
        if(upper != null && val >= upper) return false;

        return judge(node.left, lower, val) && judge(node.right, val, upper);
    }
	//中序遍历非递归
	//保证中序遍历前面的树总比后面得数小，即一个数总比前一个遍历到的数大
	public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        double inorder =  -Double.MAX_VALUE;

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
	
}