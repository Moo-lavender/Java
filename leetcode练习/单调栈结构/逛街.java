/*
链接：https://www.nowcoder.com/questionTerminal/35fac8d69f314e958a150c141894ef6a?f=discussion
来源：牛客网

编程题]逛街
热度指数：3599时间限制：C/C++ 2秒，其他语言4秒空间限制：C/C++ 256M，其他语言512M
算法知识视频讲解
小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住） 

输入描述:
输入第一行将包含一个数字n，代表楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表每一栋楼的高度。
1<=n<=100000;
1<=wi<=100000; 


输出描述:
输出一行，包含空格分割的n个数字vi，分别代表小Q在第i栋楼时能看到的楼的数量。
示例1
输入
6
5 3 8 3 2 5
输出
3 3 5 4 4 4
说明
当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，共可看到5栋楼。当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼。
*/


import java.util.Stack;
import java.util.Scanner;

/*
单调栈
高的楼会把矮的堵住，所以如果出现更高的楼就要把比它小的楼出栈
所以维护一个单调递减栈，栈的元素能看到的楼的下标
*/
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int[] rightLook = new int[n];
        int[] leftLook = new int[n];
        Stack<Integer> stack = new Stack<>();
        //右边能看到的
        for (int i = n-1; i >= 0; i--) {
            rightLook[i] = stack.size();
            //要是 >= 而不单单是 > 相同高度的楼也会挡住后面的楼
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }
        stack.clear();
        //左边能看到的
        for (int i = 0; i < n; i ++) {
            leftLook[i] = stack.size();
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }
        
        //输出
        for (int i = 0; i < n; i ++) {
            System.out.print((leftLook[i] + rightLook[i] + 1) + " ");
        }
    }
}