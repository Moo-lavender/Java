public class lowesCommonAncestor{
	//找最近的公共祖先
    public static Node lowesCommonAncestor(Node root,Node p,Node q){
        if(root == p || root ==q){
            return root;
        }
        boolean pInleft = search(root.left,p);
        boolean qInleft = search(root.left,q);
        if (pInleft && qInleft){
            return lowesCommonAncestor(root.left,p,q);
        }
        if(!pInleft && !qInleft){
            return lowesCommonAncestor(root.right,p,q);
        }
        return root;
    }
}