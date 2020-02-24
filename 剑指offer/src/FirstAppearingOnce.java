/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"
*/
import java.util.*;
public class Solution {
    private LinkedList<Character> list = new LinkedList<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        for(int i = 0; i < list.size(); i ++){
            if(ch == list.get(i)) {
                list.remove(i);
                return ;
            }
        }
        list.add(ch);
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if(list.isEmpty()) return '#';
        return list.get(0);
    }
}