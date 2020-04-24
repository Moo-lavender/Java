/*
60. 第k个排列
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"
*/
//全排列后选择，超时了
class Solution {
    int i = 0;
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public String getPermutation(int n, int k) {
        back(n);
        return res.get(k-1);
    }
    public void back(int n) {
        i ++;
        if (sb.length() == n) {
            res.add(sb.toString());
        }

        for (int i = 1; i <= n; i ++) {
            String s = String.valueOf(i);
            if (sb.indexOf(s) != -1) {
                continue;
            } 
            sb.append(s);
            back(n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (i >= k) {
            break;
        }
    }
}
//找到第k个元素后就返回
class Solution {
    int num = 0;
    public String getPermutation(int n, int k) {
        ArrayList<Character> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];
        back(res,sb,used,k);
        String ans = "";
        for (char i : res) {
            ans = ans + i;
        }
        return ans;
    }
    public boolean back(ArrayList<Character> res,StringBuilder sb,boolean[] used,int k) {
        int n = used.length;
        if (sb.length() == n) {
            if (++num == k){
                for(int i = 0; i < n; i ++) {
                    res.add(sb.charAt(i));
                }
                return true;
            }
            return false;
        }

        for ( int i = 1; i <= n; i ++) {
            if (used[i-1]) continue;
            used[i-1] = true;
            sb.append(i);
            boolean tag = back(res,sb,used,k);
            if (tag) return true;
            sb.deleteCharAt(sb.length()-1);
            used[i-1] = false;
        }
        return false;
    }
}