/*
给定一个二叉树

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node cur = root;   //每次遍历到的根节点
        Node head = null; //每一层的最左孩子
        Node prv = null;  //连接的前驱节点
		
        while (cur != null) { //外循环沿着高度遍历，每一个都是新的一层的开始
            while (cur != null) { //内循环沿着一层的每一个节点来遍历
                
				if (cur.left != null) { //左孩子不为空
                    if (prv != null) {  //判断前驱节点
                        prv.next = cur.left;   //不为空说明在这一层已经遍历过节点了，只需要连接prv和左孩子
                    } else {
                        head = cur.left;  //为空说明这一层第一次出现不为null的节点，初始化head以便下次循环
                    }
                    prv = cur.left;   //无论prv之前是否为空，下一个节点的prv一定是左孩子
                }
				
                if(cur.right != null) {
                    if (prv != null) {
                        prv.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prv = cur.right; 
                }
                cur = cur.next;    //遍历完一个节点的左右孩子，换下一个节点
            }
            cur = head;  //cur到下一层遍历，head也就是下一层第一次出现节点的位置
            head = null; //head重新置空
            prv = null;  //prv置空
        }
        return root;
    }
}






