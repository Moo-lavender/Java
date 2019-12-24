//链表中倒数第k个节点
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head,int k) {
		if(head == null||k<=0){
            return null;
        }
 
        ListNode l = head,r = head;
        for(int i=0;i<k-1;i++){
            if(r.next==null){
                return null;
            }
            r = r.next;
        }
        while(r.next!=null){
            r = r.next;
            l = l.next;
        }
        return l;

    }
}