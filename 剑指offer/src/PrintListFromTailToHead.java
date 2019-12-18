import java.util.ArrayList;
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class PrintListFromTailToHead {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode cur = listNode;
        while (cur != null) {
            result.add(0, cur.val);
            cur = cur.next;
        }
        return result;
    }
}
