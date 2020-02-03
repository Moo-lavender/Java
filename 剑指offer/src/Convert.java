/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
*/
import java.util.ArrayList;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}


public class Convert{
    private ArrayList<TreeNode> list = new ArrayList<>();
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return null;
        }
        inorderTraversal(pRootOfTree,list);
        return getRoot(list);
    }
	//中序遍历
    public void inorderTraversal(TreeNode root, ArrayList<TreeNode> list){
        if (root.left != null){
            inorderTraversal(root.left,list);
        }
        list.add(root);
        if (root.right != null){
            inorderTraversal(root.right,list);
        }
    }
	//转换指针
    public TreeNode getRoot(ArrayList<TreeNode> list){
        for(int i = 0; i < list.size() - 1; i++){
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
    }
	
}






