/*

给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:

num 的长度小于 10002 且 ≥ k。
num 不会包含任何前导零。
示例 1 :

输入: num = "1432219", k = 3
输出: "1219"
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
示例 2 :

输入: num = "10200", k = 1
输出: "200"
解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
示例 3 :

输入: num = "10", k = 2
输出: "0"
解释: 从原数字移除所有的数字，剩余为空就是0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-k-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

class Solution {
    public String removeKdigits(String num, int k) {
        /*
        此题和去除重复字母相似，但要有一个标记，记录次数，需要一个单调递增栈
        进入的数字大于栈顶就判断元素是否为第一个0，如果不是就加入，小于栈顶元素就出栈次数加一
        当次数==k 后所有的剩余元素都入栈，遍历结束后如果次数小于k，就从末尾删除栈顶元素
        最后栈为空，则返回0，使用reverse方法进行逆序
        */
        if (num == null || num.length() <= k ) {
            return "0";
        }
        int count = 0;
        char[] ch = num.toCharArray();
        Stack<Character> stack = new Stack(); 
        for (int i = 0; i < ch.length; i ++) {
            while(! stack.isEmpty() && stack.peek() > ch[i] && count < k) {
                count ++;
                stack.pop();
            } 
            if (ch[i] != '0' || !stack.isEmpty()) {
                stack.push(ch[i]);
            }
        }
        while (count < k && !stack.isEmpty()) {
            stack.pop();
            count ++;
        }
       // System.out.println(stack.toString());
        if(stack.isEmpty())
            return "0";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        //从后往前添加所以我们要逆序
        return sb.reverse().toString();
    }
}