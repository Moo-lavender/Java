/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
*/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
//1.判断是否有环
//2.如果有统计环中节点数目
//3.快节点先走环节点数，后一起走，相遇即为环的入口
public class EntryNodeOfLoop {

    public ListNode entryNodeOfLoop(ListNode pHead){
        if (pHead == null) {
            return null;
        }
        ListNode node1 = pHead;
        ListNode node2 = pHead;
        boolean flag = false;
        while (node1 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
            if (node1 == node2) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return null;
        }else {
            int n = 1;
            node2 = node2.next;
            while (node1 != node2) {
                node2 = node2.next;
                n ++;
            }
            //找入口
            node1 = node2 = pHead;
            for(int i = 0; i < n; i ++) {
                node2 = node2.next;
            }
            while(node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        }
    }
}