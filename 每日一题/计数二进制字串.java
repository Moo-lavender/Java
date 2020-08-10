/*
696. 计数二进制子串
给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。

重复出现的子串要计算它们出现的次数。

示例 1 :

输入: "00110011"
输出: 6
解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。

请注意，一些重复出现的子串要计算它们出现的次数。

另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
示例 2 :

输入: "10101"
输出: 4
解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
注意：

s.length 在1到50,000之间。
s 只包含“0”或“1”字符。

*/



class Solution {
    public int countBinarySubstrings1(String s) { //超时
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i ++) {
            int firstCount = 1, secondCount = 0;
            char key = s.charAt(i);
            boolean flag = false;//表示是否出现了第二个数字，为false表示没出现过
            for (int j = i+1; j < s.length() && secondCount < firstCount; j ++) {
                if (s.charAt(j) == key && flag) {//出现了第二个字符后又出现了第一个
                    break;
                } else if (s.charAt(j) == key && !flag) { //没出现第二个，只是第一个的情况
                    firstCount ++;
                } else {
                    secondCount ++;
                    flag = true; //已经出现了第二个数字，之后就不能出现第一个数字
                }
            }
            if (firstCount == secondCount ) {
                res ++;
            }
        }
        return res;
    }
	
	public int countBinarySubstrings2(String s) {
        /*
        last 表示前面的连续数字的个数
        cur 表示当前连续的数字的个数
        这两个统计的字符一定是不相同的
        res 表示结果，如果last > cur 表示就有一个符合条件
        例如：0 连续个数是3，那么当cur = 1，2，3时也就是 0001 00011 000111 
        每一种都是有符合解的 分别是 01 0011 000111
        */
        if (s== null || s.length() == 0) return 0;
        int n = s.length();
        int last = 0,cur = 1,res = 0;
        for (int i = 1; i < n; i ++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cur ++;
            } else {
                last = cur;
                cur = 1;
            }
            if (last >= cur) res ++;
        }
        return res;
    }
}




