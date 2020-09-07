

import java.util.ArrayList;
import java.util.Scanner;
class ListNode{
    int val;
    ListNode next;
    ListNode(){
        this.val = 0;
        this.next = null;
    }
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> res = new ArrayList<>();
        int n1 = sc.nextInt();
        ListNode head1 = new ListNode(sc.nextInt());
        ListNode cur1 = head1;
        for (int i = 1; i < n1; i ++) {
            ListNode node = new ListNode(sc.nextInt());
            cur1.next = node;
            cur1 = node;
        }
        cur1 = head1;
        int n2 = sc.nextInt();
        for (int i = 0; i < n2; i ++) {
            int num = sc.nextInt();
            while (cur1 != null && cur1.val > num) {
                cur1 = cur1.next;
            }
            if (cur1 == null) {
                break;
            }
            if (cur1.val == num) {
                res.add(num);
                cur1 = cur1.next;
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}

*/