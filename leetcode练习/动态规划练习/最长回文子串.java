/*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

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
	//z中心扩展法，先向左扩展，再向右扩展
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return new String("");
        }
        if (s.length() == 1) return s;
        char[] ch = s.toCharArray();
        int max = 1,startIndex = 0,left = 0,right = 0;
        for (int i = 0; i < ch.length; i ++) {
            int count = 1;
            left = i - 1;
            right = i + 1;
            //向左扩展
            while (left >= 0 && ch[left] == ch[i]) {
                left --;
                count ++;
            }
            while (right < ch.length && ch[i] == ch[right]) {
                right ++;
                count ++;
            }
            while (left >= 0 && right < ch.length && ch[left] == ch[right]) {
                left --;
                right ++;
                count += 2;
            }
            if (count > max) {
                max = count;
                startIndex = left;
            }
        }
        return s.substring(startIndex + 1,startIndex + max + 1 );
    }   
	//动态规划
	public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int n = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[n][n]; 

       //从l到r是否为回文串，r表示右，l表示左
        for (int r = 1; r < n; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;

                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);

    }	
	
}