import java.util.*;

//从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Print {
    ArrayList<ArrayList<Integer> > print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null){
            return res;
        }
        ArrayList<Integer> list;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur;
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            list = new ArrayList<>();
            int size = queue.size();
            while(size > 0){ //记录上一层的size
                cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                size--;
            }
            res.add(list);
        }
        return res;
    }
}