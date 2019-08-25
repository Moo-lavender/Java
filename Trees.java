import java.util.List;

class Node {
    public char value;
    public Node left = null ;
    public Node right = null;
    public Node (char value){
        this.value = value;
    }
}

public class Trees {
    public static void preOrderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(Node root){
        if (root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root){
        if (root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }
    //初始化树
    public static Node buildTree(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;
        return A;

    }

    //计算整个树的节点个数
    //遍历思想
    public static int count = 0;
    public  static  void calaCount(Node root){
        if(root == null){
            return;
        }
        count ++;
        calaCount(root.left);
        calaCount(root.right);
    }
    //汇总思想
    public  static  int calaCount2(Node root){
        if(root == null){
            return 0;
        }
        int left = calaCount2(root.left);
        int right = calaCount2(root.right);
        int count2 = left + right + 1;
        return count2;
    }

    //计算叶子节点的个数
    //遍历思想
    public  static  int leafCount = 0;
    public  static  void calaLeafCount(Node root){
        if(root == null){
            return;
        }
        calaLeafCount(root.left);
        if(root.left == null && root.right == null){
            leafCount ++;
        }
        calaLeafCount(root.right);
    }
    //汇总思想
    public static  int calaLeafCount2(Node root){
        if (root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftCount = calaLeafCount2(root.left);
        int rightCount = calaLeafCount2(root.right);
        int LeafCount = leftCount + rightCount;
        return LeafCount;
    }

    //求树的高度
    public static int calaHeight(Node root){
        if(root == null){
            return 0;
        }
        int left = calaHeight(root.left);
        int right = calaHeight(root.right);
        int height = Math.max(right,left) + 1;
        return height;
    }

    //查找（节点的值不重复）返回包含该值的节点的引用
    //首先判断根的值是否要找的值，是返回，否继续
    //去左子树中找，左子树找到，返回该引用，否则继续
    //去右子树，找到返回，没找到返回null

    public static Node search(Node root,char val){
        if (root == null){
            return null;
        }
        if(root.value == val){
            return root;
        }

        Node left = search(root.left, val);
        if(left != null){
            return left;
        }
        Node right = search(root.right, val);
        if(right != null){
            return right;
        }
        return null;
    }

    //查找，找到返回ture 不在返回false
    public static boolean search2(Node root, char val){
        if(root == null){
            return  false;
        }
        if(root.value == val){
            return true;
        }
        return (search2(root.left,val)||search2(root.right,val));
    }


    public static void main(String[] args) {
        Node root = buildTree();
        preOrderTraversal(root);
        System.out.println("-----------------------");
        inOrderTraversal(root);
        System.out.println("-----------------------");
        postOrderTraversal(root);
        System.out.println("-----------------------");
        calaCount(root);
        System.out.println(count);
        System.out.println(calaCount2(root));
        calaLeafCount(root);
        System.out.println(leafCount);
        System.out.println(calaLeafCount2(root));
        System.out.println(calaHeight(root));
        System.out.println(search2(root,'i'));
    }



}

