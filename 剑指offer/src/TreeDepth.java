//求一棵二叉树的深度
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class TreeDepth {
    public int treeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftTreeDepth = treeDepth(root.left);
        int rightTreeDepth = treeDepth(root.right);
        return Math.max(leftTreeDepth+1,rightTreeDepth+1);
    }
}