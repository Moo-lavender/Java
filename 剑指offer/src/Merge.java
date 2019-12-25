/*合并有序链表*/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Merge {
    public ListNode merge(ListNode list1,ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode head = new ListNode(0);
        ListNode last = head;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                last.next = head1;
                last = head1;
                head1 = head1.next;
            }else{
                last.next = head2;
                last = head2;
                head2 = head2.next;
            }
        }
        if(head1 != null){
            last.next = head1;
        }else{
            last.next = head2;
        }
        return head.next;
    }
}