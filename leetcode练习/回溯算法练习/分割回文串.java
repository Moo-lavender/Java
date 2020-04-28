/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/*
start表示接下来截取的字符串的位置，如果这个节点前面是回文串，才会产生start以及后面的分支
如果不是，就直接剪枝
*/
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> tmp = new ArrayList<>();
    int length;

    public List<List<String>> partition(String s) {
        length = s.length();
        if (s == null || length == 0) {
            return res;
        }
        back(s,0);
        return res;
    }
    private void back(String s ,int start) {
        if (start == length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < length; i ++){
            if (!judge(s,start,i)) {
                continue;
            }
            tmp.add(s.substring(start,i+1));
            back(s,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
    private boolean judge(String s,int start,int end) {
        while(start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
/*
每次都是用前后夹击的方法判断是否为回文串，时间复杂度是O(N)
所以就可以利用动态规划的时间换取空间的方法，减少时间复杂度
*/
class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> tmp = new ArrayList<>();
    int length;
    boolean[][]dp;

    public List<List<String>> partition(String s) {
        length = s.length();
        if (s == null || length == 0) {
            return res;
        }
        //dp[l][r]表示l到r的串是否是回文串
        dp = new boolean[length][length];
        for (int right = 0; right < length; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        back(s,0);
        return res;
    }
    private void back(String s ,int start) {
        if (start == length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < length; i ++){
            if (!dp[start][i]) {
                continue;
            }
            tmp.add(s.substring(start,i+1));
            back(s,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
