/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
*/
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return length(root) != -1;
    }
    public int length(TreeNode root){
        if(root == null) return 0;
        int leftLength = length(root.left);
        if (leftLength == -1) return -1;
        int rightLength = length(root.right);
        if (rightLength == -1) return -1;
        if (leftLength - rightLength > 1 || leftLength - rightLength < -1) {
            return -1;
        }else {
            return 1 + (leftLength > rightLength ? leftLength : rightLength);
        } 
    }
}