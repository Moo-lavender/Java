/*
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*/
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class GetNext {
    public TreeLinkNode getNext(TreeLinkNode pNode){
        if(pNode == null) return null;
        //如果该节点有右子树，那么下一个节点就是右子树的最左节点
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }else{
            while(pNode.next != null) {
                //如果该节点是父节点的左子树，那么下一个节点就是父节点
                if(pNode.next.left == pNode) {
                    return pNode.next;
                }else{//如果该节点是父节点的右子树那么下一个节点就要重新判断父节点是爷爷节点的左子树还是右子树
                    pNode = pNode.next;
                }
            }
            return null;
        }
    }
}