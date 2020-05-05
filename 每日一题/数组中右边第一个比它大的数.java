/*
题目：给定一个整型数组，数组元素随机无序的，要求打印出所有元素右边第一个大于该元素的值。

如数组A=[1,5,3,6,4,8,9,10] 输出[5, 6, 6, 8, 8, 9, 10, -1]

如数组A=[8, 2, 5, 4, 3, 9, 7, 2, 5] 输出[9, 5, 9, 9, 9, -1, -1, 5, -1]


具体思路是：我们用栈来保存未找到右边第一个比它大的元素的索引
（保存索引是因为后面需要靠索引来给新数组赋值），初始时，栈里放的是第一个元素的索引0值。
步骤如下：
（1）初始化栈，里面为第一个元素索引0值；
（2）遍历到下一个元素A[i]
	1) 如果栈不为空且当前遍历的元素值A[i]大于栈顶的元素值A[stack.peek()]，
	   说明当前元素正好是栈顶元素右边第一个比它大的元素，将栈顶元素弹出，
	   result[stack.pop()]=A[i]继续遍历的元素值A[i]是否大于新栈顶元素值A[stack.peek()]，如果大于，
	   说明A[i]也是比A[stack.peek()]右边第一个比它大的元素，将栈顶元素弹出
	   result[stack.pop()]=A[i]，一直循环，直到不满足条件1），
	   即栈顶为空或是当前遍历的元素值小于栈顶元素索引处的值。

	2) 如果栈为空，说明前面的元素都找到了比它右边大的元素，则直接将当前元素的索引放入栈中；

	3）如果当前遍历的元素值A[i]小于栈顶元素索引的值A[stack.peek()]，
	  说明还未找到栈顶元素中右边第一个比它大的元素，直接将当前遍历的元素的索引入栈即可stack.push(i);

将i++，重复步骤（2）

（3）直到遍历完所有元素，如果栈不为空，说明栈中保存的全是未找到右边第一个比它大的数组索引，
   我们依次将这些栈元素出栈，并赋值result[stack.pop()]=-1即可。

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
        int [] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int index = 1;
        while(index < length) {
            if (!stack.isEmpty() && input[index] > input[stack.peek()]) {
                result[stack.pop()] = input[index];
            }else{
                stack.push(index);
                index ++;
            }
        }
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        for (int i = 0; i < length; i ++) {
            System.out.print(result[i]);
        }
    }
}