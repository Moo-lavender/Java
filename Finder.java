import java.util.*;
//给出一个数组，求这个数组的第K大的数（不考虑去重）
public class Finder {
    public int findKth(int[] a, int n, int K) {
        Arrays.sort(a);
        Stack<Integer> stack = new Stack<>();
            for (int t : a) {
                stack.push(t);
            }
            for (int i = 0; i < K - 1 ; i++) {
                stack.pop();
            }
            int s = stack.peek();
            return s;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int K = scanner.nextInt();

        if((K > 0) && (K <= n)){
            System.out.println(new Finder().findKth(arr, n, K));
        }
    }
}
