/*
93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。

 

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
*/
class Solution {
    List<String> res = new ArrayList<>();
    Deque<String> tmp = new ArrayDeque<>(4);
    int length;
    public List<String> restoreIpAddresses(String s) {
        int count = 0;
        int index = 0;
        length = s.length();
        if (length > 12 || length < 4) {
            return res;
        }
        back(s,index,count);
        return res;
    }
    private void back(String s,int index,int count) {
        if (index == length && count == 4) {
            res.add(String.join(".", tmp));
            return;
        }
        if (length - index < (4-count) || length - index > (4-count)*3) {
                return;
        }
        for (int i = index; i < length; i ++) {
            if (i - index > 2){
                break;
            }
            if(! reasonible(s,index,i)) {
                break;
            }
            tmp.addLast(s.substring(index,i+1));
            back(s,i+1,count+1);
            tmp.removeLast();
        }
    }
    private boolean reasonible(String s,int start,int end) {
        int len = end - start + 1;
        int t = Integer.valueOf(s.substring(start,end+1));
        if (t > 255 || t < 0){
            return false;
        }
        if (len > 1 && s.charAt(start) == '0') {
            return false;
        }
        return true;
    }
}