/*
链接：https://www.nowcoder.com/questionTerminal/655a43d702cd466093022383c24a38bf
来源：牛客网

给定一个字符串，问是否能通过添加一个字母将其变为回文串。

输入描述:
一行一个由小写字母构成的字符串，字符串长度小于等于10。


输出描述:
输出答案(YES\NO).
示例1
输入
coco
输出
YES
*/

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.next();
            int i = 0;
            int j = s.length() - 1;
            int flag = 0;
            while(i <= j) {
                if(s.charAt(i) != s.charAt(j)){
                    if(i + 1 <= j && s.charAt(i+1) == s.charAt(j)){
                        i++;
                        flag ++;
                    }else if(j - 1 >= i && s.charAt(i) == s.charAt(j-1)){
                        j --;
                        flag ++;
                    }else{
                        flag += 2;
                        break;
                    }
                }else{
                    i ++;
                    j --;
                }
            }
            if(flag < 2)
                System.out.println("YES");
            else
                System.out.println("NO");
            }
    }
}