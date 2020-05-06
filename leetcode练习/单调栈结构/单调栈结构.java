/*
链接：https://www.nowcoder.com/questionTerminal/e3d18ffab9c543da8704ede8da578b55
来源：牛客网

给定一个不含有重复值的数组 arr，找到每一个 i 位置左边和右边离 i 位置最近且值比 arr[i] 小的位置。返回所有位置相应的信息。


输入描述:
第一行输入一个数字 n，表示数组 arr 的长度。

以下一行输出 n个数字，表示数组的值。


输出描述:
输出n行，每行两个数字 L 和 R，如果不存在，则值为-1，下标从0开始。
示例1
输入
7
3 4 1 5 6 2 7
输出
-1 2
0 2
-1 -1
2 5
3 5
2 -1
5 -1

 */
 /*
 单调栈结构：
 用一个栈维护一个单调递增或单调递减的序列
 
 框架(单调递增)：
 
 Stack s;
 s.push(0);
while(index < length) {
	if (!stack.isEmpty() && input[index] < input[stack.peek()]) {
		出栈
	}else{
		入栈
		index ++;
	}
}
 */
 
import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] input = new int[length];
        for (int i = 0; i < length; i ++) {
            input[i] =sc.nextInt();
        }
        int[][] result = findMinWithStack(input);
        for (int i = 0; i < result.length; i ++) {
            System.out.println(result[i][0]+" "+result[i][1]);
        }
    }
    private static int[][] findMinWithStack(int[] input) {
        int[][] result = new int[input.length][2];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int index = 1;
        while(index < input.length) {
            if (!stack.isEmpty() && input[index] < input[stack.peek()]) {
                int i = stack.pop();
                result[i][1] = index;
                if (!stack.isEmpty()){
                    result[i][0] = stack.peek();
                }else{
                    result[i][0] = -1;
                }
            }else{
                stack.push(index);
                index ++;
            }
        }
        while(!stack.isEmpty()){
            int i = stack.pop();
            result[i][1] = -1;
            if (!stack.isEmpty()){
                result[i][0] = stack.peek();
            }else{
                result[i][0] = -1;
            }
        }
        return result;
    }
}