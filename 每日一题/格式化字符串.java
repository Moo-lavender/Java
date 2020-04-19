/*
给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。

请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。

请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。

 

示例 1：

输入：s = "a0b1c2"
输出："0a1b2c"
解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
示例 2：

输入：s = "leetcode"
输出：""
解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
示例 3：

输入：s = "1229857369"
输出：""
解释："1229857369" 中只有数字，所以无法满足重新格式化的条件

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reformat-the-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public String reformat(String s) {
        if (s == null || s.length() == 0) {
            return new String("");
        }
        
        char[] chars = s.toCharArray();
        ArrayList<Character> num = new ArrayList<>();
        ArrayList<Character> ch = new ArrayList<>();
        char[] result = new char[s.length()];
        int p = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                num.add (chars[i]);
            }else {
                ch.add(chars[i]);
            }
        }
        
        int t = ch.size()- num.size();
        if (t > 1 || t < -1) {
            return new String("");
        }
        if (ch.size() > num.size()) {
            for (int i = 0; i < s.length()/2; i ++) {
                result[p++] = ch.get(i);
                result[p++] = num.get(i);
            }
            result[p] = ch.get(ch.size()-1);
        }else if(ch.size() < num.size()){
            for (int i = 0; i < s.length()/2; i ++) {
                result[p++] = num.get(i);
                result[p++] = ch.get(i);
            }
            result[p] = num.get(num.size()-1);
        }else {
            for (int i = 0; i < s.length()/2; i ++) {
                result[p++] = num.get(i);
                result[p++] = ch.get(i);
            }
        }
        return new String(result);
    }
}