//给定一个单链表和K找到链表的倒数第k个结点
//1.先求长度，然后减去k，再重新遍历  特殊性：链表长度==k或者<k的时候
//2.双引用遍历
//求链表的中间结点
//合并两个有序链表，合并后任然有序 
//找到两个单链表相交的第一个节点
class Node{
	public int val;
	public Node next;
}
public static class LinkedFindk{
	public Node FindKToTail1(Node head,int k){
		Node cur = head;
		int length;
		while(cur.next != null){
			length++;
			cur = cur.next;
		}
		if(length < k){
			return null;
		}
		Noth kth = head;
		for(int i = 0;i < (k - length);i++){
			kth = kth.next;
		}
		return kth;
	}
	public Node FindKToTai2(Node head,int k){
		Node front = head;
		Node back = head;
		for(int i = 0;i < k;i ++){
			if(front == null){
				return null
			}
			front = front.next;
		}
		while(front != null){
			front = front.next;
			back = back.next;
		}
		return back;
	}
	public Node FindMid(Node head){
		Node front = head;
		Node back = head;
		while(front != null){
			front = front.next;
			if(front == null){
				break;
			}
			back = back.next;
			front = front.next;
		}
		return back;
	}
	public Node mergeTwoLists(Node l1,Node l2){
		if(l1 == null){return l2;}
		if(l2 == null){return l1;}
		Node cur1 = l1;
		Node cur2 = l2;
		Node result = null;
		Node last = null;
		while(cur1 != null && cur2 != null){
			if(cur1.val <= cur2.val){
				if(result == null){
					cur1.next = result;
					result = cur1;
				}else{
				Node next = cur1.next;
				last.next = cur1;	
				}
				last = cur1;
				cur1 = next;
				
			}else{
				if(result == null){
					cur2.next = result;
					result = cur2;
				}else{
				Node next = cur2.next;
				last.next = cur1;
				}
				last = cur2;
				cur2 = next;
			}
		}
		if(cur1 == null ){
			last.next = cur2;
			}else(cur2 == null){
			last.next = cur1;
			}
			
		return result;
	}
	public viod main
	
}












