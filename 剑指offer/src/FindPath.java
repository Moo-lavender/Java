import java.util.ArrayList;
//二叉树中和为某一值的路径
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class FindPath {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        if(root == null)return result;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            result.add(new ArrayList<Integer>(list));
        ArrayList<ArrayList<Integer>> result1 = findPath(root.left, target);
        ArrayList<ArrayList<Integer>> result2 = findPath(root.right, target);
        list.remove(list.size()-1);
        return result;
    }
}