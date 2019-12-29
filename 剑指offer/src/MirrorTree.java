 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
//求一个二叉树的镜像二叉树
public class MirrorTree {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return ;
        }//省去也可以，加上可以提高效率
        TreeNode Node = root.left;
        root.left = root.right;
        root.right = Node;
        if(root.left != null){
            Mirror(root.left);
        }
        if(root.right != null){
            Mirror(root.right);
        }
    }
}
