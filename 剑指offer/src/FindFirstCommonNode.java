/*
输入两个链表，找出它们的第一个公共结点。
*/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/*
1.两个链表的长度可能不等，但把两个链表都合起来的长度就是相等的，
  如果由共同的尾部那两个指针必定会走到相同的位置
2.使用map的特性添加节点进去判断
*/
import java.util.HashMap;
public class FindFirstCommonNode {
    public ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
            if (cur1 != cur2) {
                if (cur1 == null) cur1 = pHead2;
                if (cur2 == null) cur2 = pHead1;
            }
        }
        return cur1;
    }
	 public ListNode findFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        HashMap<ListNode,Integer> map = new HashMap<>();
        while (cur1 != null) {
            map.put(cur1,0);
            cur1 = cur1.next;
        } 
        while (cur2 != null) {
            if(map.containsKey(cur2)){
                return cur2;
            }
            cur2 = cur2.next;
        }
        return null;
    }
}