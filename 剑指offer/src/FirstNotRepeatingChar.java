/*
第一次只出现一次的字符
在一个字符串(0<=字符串长度<=10000，全部由字母组成)
中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
*/
public class FirstNotRepeatingChar {
    public int firstNotRepeatingChar(String str) {
        int length = str.length();
        if (str == null || length == 0) {
            return -1;
        }
        int[] count = new int[58];
        for (int i = 0; i < length; i ++) {
            count[str.charAt(i)%58] ++;
        }
        for(int i = 0; i < 58; i ++) {
            if(count[str.charAt(i)%58] == 1){
                return i;
            }
        }
        return -1;
    }
}