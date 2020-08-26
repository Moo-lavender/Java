/*
17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

class Solution { 
    ArrayList<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || digits == null) return list;
        back(digits,0);
        return list;
    }

    public void back(String digits,int index) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return ;
        }

        char c = digits.charAt(index);
        String s = convert(c);
        for (int i = 0; i < s.length(); i ++) {
            sb.append(s.charAt(i));
            back(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

     private String convert(char c){
        if(c=='2') return "abc";
        if(c=='3') return "def";
        if(c=='4') return "ghi";
        if(c=='5') return "jkl";
        if(c=='6') return "mno";
        if(c=='7') return "pqrs";
        if(c=='8') return "tuv";
        if(c=='9') return "wxyz";
        return "";
    }
}