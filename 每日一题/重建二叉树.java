/*
面试题07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);

        int i;
        for (i = 0; i < inorder.length; i ++) {
            if (inorder[i] == preorder[0]) {
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder,1,i+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder,i+1,preorder.length);

        int[] leftInorder = Arrays.copyOfRange(inorder,0,i);
        int[] rightInorder = Arrays.copyOfRange(inorder,i+1,preorder.length);

        root.left = buildTree(leftPreorder,leftInorder);
        root.right = buildTree(rightPreorder,rightInorder);
        return root;
    }
}