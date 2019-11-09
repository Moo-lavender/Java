import java.util.*;
//对于一个字符串，设计一个算法，计算其是否是一个合法的字符串。
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> s = new Stack<>();
        char[] c = A.toCharArray();
        for (int i = 0; i < n; i++) {
            if(c[i] == '('){
                s.push('(');
            }else if(c[i] == ')'){
                //一定要考虑栈空啊！！！
                if(s.size() == 0){
                    return false;
                }else{
                s.pop();
                }
            }else{
                return false;
            }
        }

        if(s.size() != 0){
            return false;
        }else{
            return true;
        }
    }
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        System.out.println(new Parenthesis().chkParenthesis(s,n));
    }
}
