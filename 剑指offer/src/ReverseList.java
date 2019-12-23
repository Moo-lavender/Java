//逆置链表
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode cur = head;
        while(cur != null){
            ListNode node = new ListNode(cur.val);
            node.next = newHead;
            newHead = node;
            cur = cur.next;
        }
        return newHead;
    }
}