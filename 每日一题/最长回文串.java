/*409. 最长回文串
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。*/


/*
1. 遍历统计次数两两抵消，多余一个放中间 时间O(n) 空间O(n)
2. 统计出现个数为奇数的元素，相减 省去了最后判断的过程 时间O(n) 空间O(n)
但是1使用11ms 2使用1ms，所以尽量使用桶，而不使用map
*/
class Solution {
    public int longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i ++) {
            int c = map.getOrDefault(s.charAt(i),0);
            if (c == 0) {
                map.put(s.charAt(i),1);
            } else {
                count += 2;
                map.put(s.charAt(i),0);
            }
        }
        if (count < s.length()) {
            count ++;
        }
        return count;
    }
	public int longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] arr = new int[128];
        for (char c : s.toCharArray())  {
            arr[c] ++;
        }
        int count = 0;
        for (int tmp : arr) {
            if(tmp != 0) {
                count += (tmp % 2);
            }
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }
}