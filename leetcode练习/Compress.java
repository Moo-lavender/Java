/*
给定一组字符，使用原地算法将其压缩。
压缩后的长度必须始终小于或等于原数组长度。
数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。

其中 read 表示读取数组位置，而write 表示写位置
anchor表示每一个连续的字母的开头位置
*/
public class Compress {
    public static char[] compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            //不与下一个字母相同或者不到数组结尾
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                //加判断时为了保证某一个字母只有一个时就不需要求数量压缩
                if (read > anchor) {
                    /*如果这样转化，当个数大于9时就会出现问题
                    int tmp = read - anchor + 1;
                    char count = (char)(tmp +'0');
                    chars[write ++] = count;*/
                   for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        char[] c = {'a','a','b','b','c','c','c'};
        System.out.println(compress(c));
    }
}
