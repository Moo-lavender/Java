 //给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
       if(s.length() == 0 || s == null){
           return 0;
       } 
       char[] ch = s.toCharArray();
       int count = 0;
       for(int i = s.length()-1; i >=0; i--){
           if(ch[i] != ' '){
               count ++;
           }else if(count > 0){
               return count;
           }
       }
       return count;
    }
}