/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i;
        for (i = 0; i < inorder.length; i ++) {
            if (inorder[i] == root.val) {
                break;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder,1,i+1); //i+1 不包含
        int[] rightPreorder = Arrays.copyOfRange(preorder,i+1,preorder.length);

        int[] leftInorder = Arrays.copyOfRange(inorder,0,i);
        int[] rightInorder = Arrays.copyOfRange(inorder,i+1,inorder.length);

        root.left = buildTree(leftPreorder,leftInorder);
        root.right = buildTree(rightPreorder,rightInorder);
        return root;
    }
}
