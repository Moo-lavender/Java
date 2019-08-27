import java.util.LinkedList;
import java.util.Queue;
class TreeNode {
    public int val;
    public TreeNode left = null ;
    public TreeNode right = null;
    public TreeNode (int value){
        this.val = value;
    }
}

public class isComplete {
    public static boolean isComliete(TreeNode root){
        if (root == null){
            return  true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(true){
            TreeNode front = queue.poll();
            if(front == null) {
                break;
            }
                queue.add(front.left);
                queue.add(front.right);
        }

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null) {
                return false;
            }
        }
        return true;
    }
}
