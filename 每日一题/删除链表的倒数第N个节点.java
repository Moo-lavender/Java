/*19. 删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rec=new ListNode(0);
        rec.next=head;
        ListNode p=rec;
        ListNode q=head;
        for(int i=1;i<=n;i++){
            q=q.next;
        }
        while(q!=null){
            p=p.next;
            q=q.next;
        }
        p.next=p.next.next;
        return rec.next;
    }
}