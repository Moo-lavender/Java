
/*
请实现两个函数，分别用来序列化和反序列化二叉树

二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
从而使得内存中建立起来的二叉树可以持久保存。
序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），
以 ！ 表示一个结点值的结束（value!）。

二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
*/
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
//用层序遍历
import java.util.*;
public class SerializeAndDeserialize {
    public String Serialize(TreeNode root) {
        if (root == null) return new String("");
        StringBuffer sb = new StringBuffer("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null");
            }
            sb.append(",");
        }
		//把最后一个,删去
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
    
    public TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String string = str.substring(1,str.length() - 1);
        String[] nodes = string.split(",");//每个元素都是树的node节点
        int index = 0;//Str序列的索引
        //根节点
        TreeNode root = buildNode(nodes[index ++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = buildNode(nodes[index ++]);
            node.right = buildNode(nodes[index ++]);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    private TreeNode buildNode(String node){
        if (node.equals("null")){
            return null;
        }
        //返回重建的Node，其中val是node
        return new TreeNode(Integer.valueOf(node));
    }
}