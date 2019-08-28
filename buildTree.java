class buildTree{
	    //给前序中序还原树
    public static Node buildTree1(List<Character> preorder,List<Character> inorder){
        char rootValue = preorder.get(0);
        int leftCount = inorder.indexOf(rootValue);
        Node root = new Node(rootValue);
        List<Character> leftPreorder = preorder.subList(1,1 + leftCount);
        List<Character> leftInorder = inorder.subList(0, leftCount);
        Node left = buildTree1(leftPreorder,leftInorder);
        root.left = left;
        List<Character> rightPreorder = preorder.subList(1 + leftCount ,preorder.size());
        List<Character> rightInorder = inorder.subList(leftCount + 1,inorder.size());
        Node right = buildTree1(rightPreorder,rightInorder);
        root.right = right;
        return root;
    }
    //给中序和后续还原树
    public static Node buildTree2(List<Character> inorder,List<Character> postorder){
        char rootValue = postorder.get(postorder.size() - 1);
        int leftCount = inorder.indexOf(rootValue);
        Node root = new Node(rootValue);
        List<Character> leftInorder = inorder.subList(0, leftCount);
        List<Character> leftPostorder = postorder.subList(0, leftCount);
        Node left = buildTree1(leftInorder,leftPostorder);
        root.left = left;
        List<Character> rightInorder = inorder.subList(leftCount + 1 , inorder.size());
        List<Character> rightPostorder = postorder.subList(leftCount , postorder.size() - 1);
        Node right = buildTree1(rightInorder,rightPostorder);
        root.right = right;
        return root;
    }

}