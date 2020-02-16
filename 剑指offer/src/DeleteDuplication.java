/*

在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
1. 例如，链表1->2->3->3->4->4->5 处理后为 1->2->3->4->5
2. 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
*/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class DeleteDuplication {
    public ListNode deleteDuplication1(ListNode pHead){
        if(pHead == null) return null;
        ListNode fast = pHead;
        ListNode low = pHead;
        while(fast != null) {
            fast = fast.next;
            while (fast != null && low.val == fast.val) {
                fast = fast.next;
            }
            low.next = fast;
            low = low.next;
            if(fast != null && fast.next != null)
                fast = fast.next;
        }
        return pHead;
    }
	
	 public ListNode deleteDuplication2(ListNode pHead){
        if (pHead == null || pHead.next == null) 
            return pHead;
 
        ListNode head = new ListNode(-1); // 新建一个头结点，防止链表中头结点是重复节点被删除。
        ListNode trail = head;
 
        while (pHead != null) {
            ListNode node = pHead.next;
            boolean flag = false;
            while (node != null && pHead.val == node.val) {
                node = node.next;
                flag = true;
            }
            if (!flag) {
                trail.next = pHead;
                trail = trail.next;
            }
            pHead = node;
        }
        trail.next = null; // 1->2->3->3->3
        return head.next;
    }
	
}