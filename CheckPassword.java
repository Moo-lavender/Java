import java.util.Scanner;
/*
* 密码要求：
* 1.长度大于8
* 2.大小写字母，数字，其它字符 四种必须包含三种以上
* 3.相同字串的长度不超过2*/
public class CheckPassword {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(s);
            boolean length = limitLength(s);
            boolean category = limitCategory(s);
            boolean substring =  limitSubstring(s);
            if(length && category && substring){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
    public static boolean limitLength(String s){
        if(s.length() > 8){
            return true;
        }else{
            return false;
        }
    }
    public static boolean limitCategory(String s){
        int count = 0;
        boolean b1 = true;
        boolean b2 = true;
        boolean b3 = true;
        boolean b4 = true;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z' && b1){
                count ++;
                b1 = false;
            }else if(c >= 'a' && c <= 'z' && b2){
                count ++;
                b2 = false;
            }else if(c >= '1' && c <= '9' && b3){
                count ++;
                b3 = false;
            }else if(b4){
                count ++;
                b4 = false;
            }
        }
        if(count >= 3){
            return true;
        }else{
            return false;
        }
    }
    public static boolean limitSubstring(String s){
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            char begin = ch[i];
            for(int j = i + 1; j < ch.length - 3; j++){
                if(begin == ch[j]){
                    String s1 = s.substring(i,i+3);
                    String s2 = s.substring(j,j+3);
                    if(s1.equals(s2)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
