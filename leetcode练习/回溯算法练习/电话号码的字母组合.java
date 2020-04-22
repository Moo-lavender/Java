/*
17
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
//经典回溯框架
/*
1. 一个总存放符合条件的情况的结果集
2. 一个正在添加情况
3. 对未选择的节点进行选择
4. 再次进行回溯
5. 删除此次选择
*/
class Solution { 
    ArrayList<String> list = new ArrayList<>(); //返回结果集
    StringBuilder sb = new StringBuilder(); //正在添加节点

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || digits == null) return list;
        back(digits,0);
        return list;
    }

    public void back(String digits,int index) {
		//说明此次情况已经得到，加入结果集中
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return ;
        }

        char c = digits.charAt(index); 
        String s = convert(c); //得到对应的字符集合
        for (int i = 0; i < s.length(); i ++) { //对每一个字符进行遍历找情况
            sb.append(s.charAt(i)); //选择添加 
            back(digits,index+1);   //继续回溯
            sb.deleteCharAt(sb.length()-1); //撤销选择
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