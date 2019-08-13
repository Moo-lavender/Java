/*
1.逆置单链表
2.删除所有的val
3.合并两个有序单链表135  234   123345
4.删除有序链表中重复节点
5.复制复杂链表
*/
class Node{
	public int val;
	public Node next;
	public Node random;
	public Node(int val){
		this.val = val;
		this.next = null;
	}
}
public class Practice{
	public static Node reverseList(Node head){               //逆置单链表
		//遍历单链表然后进行头插
		Node newList = null;
		Node cur = head;
		Node next = null;
		while(cur != null){
			next = cur.next;
			cur.next = newList;
			newList = cur;
			cur = next;
		}
		return newList;
	}
	
	public static void show(Node head){                      //打印显示链表
		Node cur = head;
		while(cur != null){
			System.out.printf("%d->",cur.val);
			cur = cur.next;
		}
		System.out.println("null");
	}
	
	public static Node removeAllVal(Node head,int x){        //删除所有的val
		//添加一个前驱结点
		if(head.next == null){
			return null;
		}
		Node newList = head;
		Node pre = head;
		Node cur = head.next;
		while(cur != null){
			if(cur.val == x){
			pre.next = cur.next;
			}else{
				pre = pre.next;	
			}
			cur = cur.next;
		}
		if(newList.val == x){
			newList = newList.next;
		}
		return newList;
	}
	
	public static Node mergeList(Node head1,Node head2){     //合并有序链表 
		Node cur1 = head1;
		Node cur2 = head2;
		Node newList = null;
		Node last = null;
		Node Next1 = null;
		Node Next2 = null;
		if (cur1 == null){return head2;}
		if(cur2 == null){return head1;}
        
		while (cur1 != null && cur2 != null){
			if(cur1.val <= cur2.val){
				 Next1 = cur1.next;
				if(newList == null){
					Next1 = cur1.next;
					cur1.next = newList;
					newList = cur1;
				}else{
					last.next = cur1;
				}
				last = cur1;
				cur1 = Next1;
			}else{
				Next2 = cur2.next;
				if(newList == null){
					cur2.next = newList;
					newList = cur2;
				}else{
					last.next = cur2;
				}
				last = cur2;
				cur2 = Next2;
			}
			
		}
		if(cur1 != null){
			last.next = cur1;
		}else{
			last.next = cur2;
		}
		return newList;
		
		
	}
	
	public static Node  copyRandomList(Node head){
		if (head == null){return null;}
		Node cur = head;
		//给每个节点复制一个相同的节点在后面
		while(cur != null){
			Node newNode = new Node(cur.val);
			newNode.next = cur.next;
			cur.next = newNode;
			cur = cur.next.next;
			}
		//复制random的指向
		cur = head;
		while(cur != null){
			if (cur.random == null){
				cur.next.random = null;
			}else{
			cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		//拆分两个链表
		Node newHead = head.next;
		cur = head;
		Node Next = null;
		while(cur != null){
			Node node = cur.next;
			cur.next = node.next;
		   if(node.next != null){
		    node.next = node.next.next;
		    }
			cur = cur.next;
		}
		return newHead;
	}
	
	public static void main(String[] args){                  //主函数
	    Node n1 = new Node(1);
		Node n2 = new Node(3);
		Node n3 = new Node(5);
		Node n4 = new Node(5);
		Node n5 = new Node(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		n1.random = n2;
		n2.random = n1;
		n3.random = n3;
		n4.random = null;
		n5.random = n3;
		
		Node n6 = new Node(2);
		Node n7 = new Node(4);
		Node n8 = new Node(6);
		Node n9 = new Node(7);
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = null;
		
	
		//Node result = new Practice().reverseList(n1);
		Node result = reverseList(n1);             //逆置单链表
		show(result);
		Node result2 = reverseList(result);        //逆置单链表
		show(result2);	
		
		Node result3 = removeAllVal(result2,5);    //删除所有的val
		show(result3);
		
		show(n6);                               
		Node result4 = mergeList(n1,n6);           //合并有序链表
		show(result4);
		
		Node result5 = copyRandomList(n1);
		show(result5);
	}

}
