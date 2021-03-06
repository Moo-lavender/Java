/*
20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
*/

class Solution {
    public boolean isValid1(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false; 
        }
        return stack.isEmpty();
    }
	 public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c =='{' || c == '[') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ( !judge(top,c)) return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
    private boolean judge(char top,char c) {
        if (top == '(' && c == ')') return true;
        if (top == '{' && c == '}') return true;
        if (top == '[' && c == ']') return true;
        return false;
    }
}
