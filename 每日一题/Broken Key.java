/*
On a broken keyboard, some of the keys are worn out. So when you type some sentences, the characters
corresponding to those keys will not appear on screen.

Now given a string that you are supposed to type, and the string that you actually type out, please list those keys
which are for sure worn out.

输入描述:
Each input file contains one test case. For each case, the 1st line contains the original string, and the 2nd line contains the typed-out string. Each string contains 
no more than 80 characters which are either English letters [A-Z] (case 
insensitive), digital numbers [0-9], or "_" (representing the space). It is guaranteed that both strings are non-empty.


输出描述:
For each test case, print in one line the keys that are worn out, in the order of being detected. The English letters must be capitalized. 
Each worn out key must be printed once only. It is guaranteed that there is at least one worn out key.
示例1
输入
7_This_is_a_test<br/>_hs_s_a_es
输出
7TI
*/

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String soriginal = sc.nextLine().toUpperCase();
        String stypedOut = sc.nextLine().toUpperCase();
        char[] original = soriginal.toCharArray();
        char[] typedOut = stypedOut.toCharArray();
        Set<Character> set = new LinkedHashSet<>();
        int i = 0;
        int t = 0;
        while(t < typedOut.length && i < original.length){
            if( original[i] != typedOut[t]){
                set.add(original[i]);
            }else{
                t++;
            }
            i++;
        }
        while(i != original.length){
            set.add(original[i]);
            i++;
        }
        for(Character character: set){
            System.out.print(character);
        }
    }
}