/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头

*/
//Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
 
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = new ListNode(0);
        ListNode last = result;
        int p = 0;
        while (head1 != null || head2 != null){
            int sum;
            int x = (head1 != null)? head1.val : 0;
            int y = (head2 != null)? head2.val : 0;
            sum = x + y + p;
            ListNode node = new ListNode(0); 
            node.val = (sum < 10)? sum : sum % 10;
            p = (sum < 10)? 0 : 1;
            last.next = node;
            last = last.next;
            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }
        if(p == 1){
            last.next = new ListNode(1);
        }
        return result.next;
    }
}