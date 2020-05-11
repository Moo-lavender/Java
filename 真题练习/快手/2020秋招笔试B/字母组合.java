/*

链接：https://www.nowcoder.com/questionTerminal/6e59f6e111874e5fb14b81f2f626d491?answerType=1&f=discussion
来源：牛客网

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合，按照字典序升序排序,如果有重复的结果需要去重

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



输入描述:
输入2-9数字组合， 字符串长度 1<=length<=20


输出描述:
输出所有组合
示例1
输入
23
输出
[ad, ae, af, bd, be, bf, cd, ce, cf]
示例2
输入
92
输出
[wa, wb, wc, xa, xb, xc, ya, yb, yc, za, zb, zc]
示例3
输入
458
输出
[gjt, gju, gjv, gkt, gku, gkv, glt, glu, glv, hjt, hju, hjv, hkt, hku, hkv, hlt, hlu, hlv, ijt, iju, ijv, ikt, iku, ikv, ilt, ilu, ilv]
*/


import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String s = sc.nextLine();
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        back(res,sb,s,0);
        System.out.println(res);
    }
    private static void back (ArrayList<String> res,StringBuilder sb,String s,int index) {
        if (sb.length() == s.length()) {
            res.add (sb.toString());
            return ;
        }
        char c = s.charAt(index);
        String strs = convert(c);
        for (int i = 0; i < strs.length(); i ++) {
            sb.append(strs.charAt(i));
            back(res,sb,s,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    private static String convert (char c) {
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