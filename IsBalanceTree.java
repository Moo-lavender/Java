/*判断一颗树是否平衡二叉树*/
public class IsBalanceTree {
     class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isBalance(TreeNode root) {
        if(root==null)
            return true;
        if(Math.abs(deepth(root.left)-deepth(root.right))>1)
            return false;
        else
            return isBalance(root.left)&isBalance(root.right);
    }
    public int deepth(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(deepth(root.left),deepth(root.right))+1;
    }
}
