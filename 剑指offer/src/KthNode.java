/*
给定一棵二叉搜索树，请找出其中的第k小的结点。
例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
*/
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
//中序遍历就是增序
import java.util.*;
public class KthNode {
    private ArrayList<TreeNode> list = new ArrayList<>();
    private TreeNode kthNode(TreeNode pRoot, int k)
    {
        if(k <= 0) return null;
        leftRootRight(pRoot); 
        if(k > list.size()) return null;
        return list.get(k - 1);
    }
    private void leftRootRight(TreeNode pRoot) {
        if(pRoot == null) return;
        leftRootRight(pRoot.left);
        list.add(pRoot);
        leftRootRight(pRoot.right);
    }
}