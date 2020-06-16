/*
定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
	//粗暴的遍历，超时 时间O(n^3)空间O(1)
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = s.substring(0,1);
        int len = s.length();
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < i; j ++) {
                int left = j, right = i;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        break;
                    }
                    left ++;
                    right --;
                }
                if (left >= right && res.length() < (i - j + 1)) {
                    res = s.substring(j,i+1);
                }
            }
        }
        return res;
    }
	
	//二维数组的动态规划
	/*
	dp[i][j] 表示i-j的字符串是否为回文串
	按照列来遍历，从上到下，从左到右，所以列不变行增加
		0	1	2	3	4
	0	T	
	1	F	T
	2		F	T
	3			F	T
	4				F	T 
	
	时间O(n^2) 空间O(n^2)
	*/
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean [len][len];
        String res = s.substring(0,1);
        for (int j = 0; j < len; j ++) {
            for (int i = 0; i < j; i ++) {
                if (s.charAt(i) == s.charAt(j) && ((j-i <= 2) || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (res.length() < (j-i+1)) {
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
	
	/*
	一维数组的动态规划
	时间O(n^2) 空间O(n)
	*/
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[] dp = new boolean[len];
        String res = s.substring(0,1);
        for (int j = 0; j < len; j ++) {
            for (int i = 0; i < j; i ++) {
                if (s.charAt(i) == s.charAt(j) && ((j-i <= 2) || dp[i+1])) {
                    dp[i] = true;
                    if (res.length() < (j-i+1)) {
                        res = s.substring(i,j+1);
                    }
                }else {
                    dp[i] = false; //记得置回状态
                }
            }
        }
        return res;
    }
}