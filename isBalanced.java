public class isBalanced{
	//是否平衡二叉树
    public static boolean isBalanced(Node root){
        if(root == null){
            return false;
        }
        boolean leftBalance = isBalanced(root.left);
        if(!leftBalance){
            return false;
        }

        boolean rightBalance = isBalanced(root.right);
        if(!rightBalance){
            return false;
        }
        int leftHeight = calaHeight(root.left);
        int rightHeight = calaHeight(root.right);
        int diff = leftHeight - rightHeight;
        if(diff > 1||diff < -1){
            return false;
        }
        return true;
    }
}