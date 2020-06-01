/*
根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/daily-temperatures
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public int[] dailyTemperatures1(int[] T) {
	//使用单调递减栈存储下标
	//遍历数字，小于栈顶元素入栈，大于栈顶元素不断出栈，计算对应栈顶元素的结果为 i-stack.pop()
	//遍历结束后还在栈中的元素就是之后都不会升高的元素了，默认为0
	
   
	int[] res = new int[T.length];

	Stack<Integer> stack = new Stack<>();
	for (int i = 0; i < T.length; i ++) {
		while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
			int index = stack.pop();
			res[index] = i - index;
		}
		stack.push(i);
	}
	return res;
}
public int[] dailyTemperatures2(int[] T) {
	//从最后一天倒推來，最后一天为0，看倒数第二天的，如果比后一天小，结果为1
	//否则，如果后一天为0，结果为0，如果都不是，就和比后一天大的那一天进行比较
    int[] res = new int[T.length];
    res[T.length - 1] = 0;
    for (int i = T.length - 2; i >= 0; i--) {
        for (int j = i + 1; j < T.length; j += res[j]) {
            if (T[i] < T[j]) {
                res[i] = j - i;
                break;
            } else if (res[j] == 0) {
                res[i] = 0;
                break;
            }
        }
    }
    return res;
}