 //给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 //判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
 //如果可以构成，返回 true ；否则返回 false。

 public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] r = new int[26];
        int[] m = new int[26];
        for(int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            int t = ch - 'a';
            r[t] ++;
        }
        for(int i = 0; i < magazine.length(); i++){
            char ch = magazine.charAt(i);
            int t = ch - 'a';
            m[t] ++;
        }
        for(int i = 0; i < 26; i++){
            if(r[i] > m[i]){
                return false;
            }
        }
        return true;
    }
}