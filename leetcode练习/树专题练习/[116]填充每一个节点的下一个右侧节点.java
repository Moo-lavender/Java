/*
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
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
	//时间O(n) 空间O(n) 迭代
    public Node connect1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return root;
        queue.add(root);
        while(! queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size - 1; i ++) {
                Node node1 = queue.poll();
                Node node2 = queue.peek();
                node1.next = node2;
                if (node1.left != null) {
                    queue.add(node1.left);
                }
                if(node1.right != null) {
                    queue.add (node1.right);
                }
            }
            Node tmp = queue.poll();
            tmp.next = null;
             if (tmp.left != null) {
                queue.add(tmp.left);
             }
            if(tmp.right != null) {
                queue.add (tmp.right);
             }
        }
        return root;
    }
	//时间O(n)空间O(n) 递归
	public Node connect2(Node root) {
        if(root == null) return root;
        
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            root.right.next = root.next == null ? null : root.next.left;   
        }
        connect2(root.left);
        connect2(root.right);
        return root;
    }
	//时间O(n)空间O(1) 迭代
	public Node connect3(Node root) {
        if (root == null) return null;
        root.next = null;
        
        Node head = root;
        Node cur = root;
        Node Phead = root;
        
        while (Phead.left != null) {
            cur = head.left;
            
            while (cur != null) {
                if (cur == head.left) {
                    cur.next = head.right;
                }
                if (cur == head.right) {
                    cur.next = head.next == null ? null : head.next.left;
                    head = head.next;
                }
                
                cur = cur.next;
            }
            
            Phead = Phead.left; 
            head = Phead;
        }
        return root;
    }
	
}