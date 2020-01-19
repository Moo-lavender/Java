/*给定一个字符串 S，返回 “反转后的” 字符串，
* 其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
* 先将所有的字母入栈，再遍历S中所有字符，若为字母就出栈，非字母就保留
* Character.isLetter()方法判断一个字符是不是字母
*/
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        Stack<Character> s = new Stack();
        for(char c : S.toCharArray()){
            if(Character.isLetter(c)){
                s.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        for(char c : S.toCharArray()){
            if(Character.isLetter(c)){
                ans.append(s.pop());
            }else{
                ans.append(c);
            }
        }
        return ans.toString();
    }
}