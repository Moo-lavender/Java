/*
* 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
* 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针*/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class PartitionLinkedList {
    public ListNode partition(ListNode pHead, int x) {
        ListNode cur = pHead;
        ListNode smallHead = null;
        ListNode smallLast = null;
        ListNode bigLast = null;
        ListNode bigHead = null;
        if (pHead == null){
            return null;
        }
        while(cur != null){
            if(cur.val >= x){
                ListNode node = new ListNode(cur.val);
                if(bigLast != null){
                    bigLast.next = node;
                }else{
                    bigHead = node;
                }
                bigLast = node;         //头插
            }else{
                ListNode node = new ListNode(cur.val);
                if(smallLast != null){
                    smallLast.next = node;
                }else{
                    smallHead = node;
                }
                smallLast = node;
            }
            cur = cur.next;
        }
        if(smallLast != null && bigHead != null) {
            smallLast.next = bigHead;
        }
        if(smallHead == null){
            if(bigHead == null){
                return null;
            }else{
                return bigHead;
            }
        }
        return smallHead;
    }
}
