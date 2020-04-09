/*
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/*
回溯算法：
1. 找到终止条件
2. 加入选择
3. 递归
4. 撤销选择
*/
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) return ans;
        StringBuilder s = new StringBuilder();
        //可用的左括号和右括号的数量
        backtrack(n,n,s);
        return ans;
    }
    private void backtrack(int left,int right,StringBuilder s) {
        if (right < left) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            ans.add(s.toString());
            return;
        }

        //放一个'('
        s.append('(');
        backtrack(left-1,right,s);
        s.deleteCharAt(s.length() - 1); //撤销选择

        //放一个')'
        s.append(')');
        backtrack(left,right-1,s);
        s.deleteCharAt(s.length() - 1);//撤销选择
    }
}