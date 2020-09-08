/*
分配任务
时间限制： 3000MS
内存限制： 589824KB
题目描述：
如果你是一个领导，需要给员工分配任务，每个员工只能做一个任务（任务不能重复分配给员工），且员工都有一个能力值x ，同时每个任务都有适宜完成系数y，如果y>=x,可以把任务分配给这个员工且认为该员工能完成任务。请问给定任务列表最多能有多少个员工可以完成任务。



输入描述
员工数组，数组的值为能力值，数组的个数为员工数量

任务数组，数组的值为任务适宜的完成系数，数组的个数为任务数量

输出描述
能完成任务的最大员工数量


样例输入
1 2 3 4
1 1
样例输出
1

提示
输入：
1 2 3 4
1 1
说明：有4个员工，能力值从1-4，现在有2个任务，适宜完成系数都是1，所以只有让能力是1的员工来做这个任务，输出是1
输入：
1 2
1 2 3 
说明：有2个员工，能力值从1-2，现在有3个任务，适宜完成系数是1-3，所以能力1和2的员工都能完成，输出是2
*/
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] p = s1.split(" ");
        String[] w = s2.split(" ");
        int res = 0;
        int[] people = new int[p.length];
        int[] work = new int[w.length];
        for (int i = 0; i < p.length; i ++) {
            people[i] = Integer.valueOf(p[i]);
        }
        for (int i = 0; i < w.length; i ++) {
            work[i] = Integer.valueOf(w[i]);
        }
        Arrays.sort(people);
        Arrays.sort(work);
        int i = 0, j = 0;
        while (i < people.length && j < work.length) {
            if (work[j] >= people[i]) {
                i ++;
                j ++;
                res ++;
            }else if (work[j] < people[i]) {
                break;
            }
        }
        System.out.println(res);
    }
}

