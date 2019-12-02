/*
给定两个链表，分别作为两个整数，个位数在前，求两个链表中数字相加后的结果
例如{1，5，6}{2，4，3}
得到{3，9，9}
*/
public class LinkedListAdd {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode aHead = a;
        ListNode bHead = b;
        ListNode result = null;
        ListNode last = null;
        if(a == null){
            return b;
        }
        if(b == null){
            return a;
        }
        if(a == null && b == null){
            return null;
        }
        int p = 0; //进位
        while(aHead != null && bHead != null){
            int newVal = aHead.val + bHead.val + p;
            if(newVal >= 10){
                p = 1;
                newVal = newVal - 10;
            }else{
                p = 0;
            }
            ListNode node = new ListNode(newVal);
            if(result == null){
                result = node;
            }else{
                last.next = node;
            }
            last = node;
            aHead = aHead.next;
            bHead = bHead.next;
        }

        if(aHead == null && bHead == null && p == 1){
            ListNode listNode = new ListNode(1);
            last.next = listNode;
        }

        ListNode aLast = aHead;
        ListNode bLast = bHead;

        if(aHead != null){
            if(p != 0){
                while(p == 1 && aLast != null){
                    int newVal = aLast.val + p;
                    if(newVal >= 10){
                        newVal -= 10;
                        p = 1;
                    }else{
                        p = 0;
                    }
                    aLast.val = newVal;
                    aLast = aLast.next;
                }
                if(p == 1){
                    ListNode listNode = new ListNode(1);
                    aLast.next = listNode;
                }
            }
            last.next = aHead;
        }else if (bHead != null){
            if(p != 0){
                while(p == 1 && bLast != null){
                    int newVal = bLast.val + p;
                    if(newVal >= 10){
                        newVal -= 10;
                        p = 1;
                    }else{
                        p = 0;
                    }
                    bLast.val = newVal;
                    bLast = bLast.next;
                }
                if(p == 1){
                    ListNode listNode = new ListNode(1);
                    bLast.next = listNode;
                }
            }
            last.next = bHead;
        }
        return result;
    }

}

