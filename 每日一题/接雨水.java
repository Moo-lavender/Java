/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
*/
class Solution {
    public int trap(int[] height) {
        //首先确定此题使用单调栈,单调递减栈,遍历后,只要出现大于栈顶元素,就说明可以接到水
        //栈中存放下标,出现大于栈顶时,宽为 i-stack.peek()-1 ,
        //高为 min(height[i],stack.peek()) - stack().pop()
        //用一个sum变量保存每一部分的值最后进行相加

        if (height == null || height.length == 0) {
            return 0;
        }
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i ++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int index = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int weight = i - stack.peek() - 1;
                int hei = Math.min(height[i],height[stack.peek()]) - height[index];
                sum += weight * hei;
            }
            stack.push(i);
        }
        return sum;
    }
}