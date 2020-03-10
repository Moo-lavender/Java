/*
链接：https://www.nowcoder.com/questionTerminal/b0850698cb41449188344cdb647f3e99
来源：牛客网

请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。

给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
*/
import java.util.*;

public class Replacement {
    public String replaceSpace1(String iniString, int length) {
        if (iniString == null || length == 0) {
            return new String("");
        }
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < length; i ++) {
            char ch = iniString.charAt(i);
            if(ch == ' '){
                sb.append("%20");
            }else{
                sb.append(ch);
            }
        }
        return String.valueOf(sb);
    }
	
	public String replaceSpace2(String iniString, int length) {
        if(iniString == null || length == 0) {
            return new String("");
        }
        int count = 0;
        char[] ch = iniString.toCharArray();
        for(int i = 0; i < length; i ++) {
            if(ch[i] == ' '){
                count ++;
            }
        }
        char[] newchar = new char[2 * count + length];
        int i = length - 1;
        int j = newchar.length - 1;
        while(i >= 0 && j >= 0){
            if(ch[i] != ' ') {
                newchar[j] = ch[i];
                i --;
                j --;
            }else{
                newchar[j --] = '0';
                newchar[j --] = '2';
                newchar[j --] = '%';
                i--;
            }
        }
        return new String(newchar);
    }
	
}