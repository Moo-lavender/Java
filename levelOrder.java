import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一个二叉树，返回其按层次遍历的节点值。
class TreeNode {
    public int val;
    public TreeNode left = null ;
    public TreeNode right = null;
    public TreeNode (int value){
        this.val = value;
    }
}

public class levelOrder {
    private static  class Element{
        int level;
        TreeNode node;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList<>();
        if(root == null){
            return retList;
        }
        Queue<Element> queue = new LinkedList<>();
        Element e = new Element();
        e.node = root;
        e.level = 0;
        queue.add(e);

        while (!queue.isEmpty()) {
            Element front = queue.poll();

            if(front.level == retList.size()){
                retList.add(new ArrayList<>());
            }
            retList.get(front.level).add(front.node.val);

            if (front.node.left != null) {
                Element l = new Element();
                l.node = front.node.left;
                l.level = front.level + 1;
                queue.add(l);
            }
            if (front.node.right != null) {
                Element r = new Element();
                r.node = front.node.right;
                r.level = front.level + 1;
                queue.add(r);
            }

        }
        return retList;
    }



}
















