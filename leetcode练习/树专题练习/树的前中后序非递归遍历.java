public class Main{
	public static void preOrderNoRecur(Node head) {
		if(head != null) {
			Stack<Node> s = new Stack<Node>();
			s.push(head);    					//压入根节点
			while(!s.isEmpty()) {
				head = s.pop();   				//弹出节点
				System.out.print(head.data+" "); 
				if(head.right != null) {                          //压入右孩子
					s.push(head.right);
				}
				if(head.left != null) {                           //压入左孩子
					s.push(head.left); 
				}
			}
		}
	}
	public static void inOrderNoRecur(Node head) {
	if(head != null) {
		Stack<Node> s = new Stack<Node>();
		while(!s.isEmpty()  || head != null) {  
			if(head != null) {                      
				s.push(head);                  
				head = head.left;
			}else {                                
				head = s.pop();
				System.out.print(head.data+" ");
				head = head.right;               
			}
		}
		
	}
	public void postorderNoRecur(Node head) {
		Node h = head;
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(head);
			Node c = null;
			while (! stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().val + " ");
					h = c;
				}
			}
		}
	}
}
