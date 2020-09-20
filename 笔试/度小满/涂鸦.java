/*小A正在学画画，现在，线稿已经画好了，只剩下涂色部分了。但是小A发现，他的颜料不够了。每一块颜料能涂一个色块，每一个色块的颜色是事先决定好了的。 由于颜料不够，小A只能尽其所能来涂色。如果一个色块没有了颜料，就不能涂色。现在，给你画中需要的色块颜色，和小A现在手上有的颜料，请你计算小A能涂多少个色块。

输入描述
输入包含两个字符串，都仅包含大写字母，每一种字母代表一种颜色。 第一个字符串S代表小A手上的颜料，第二个字符串T代表画需要的颜料。
1≤|S|,|T|≤1000
输出描述
输出包含一个数，即最多能涂多少个色块。
样例输入
AAB
ABC
样例输出
2
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i ++) {
            char c = s1.charAt(i);
            int num = map.getOrDefault(c,0);
            map.put(c,num+1);
        }
        int res = 0;
        for (int i = 0; i < s2.length(); i ++) {
            char c = s2.charAt(i);
            int num = map.getOrDefault(c,-1);
            if (num <= 0) {
                continue;
            }else {
                res ++;
                map.put(c,num-1);
            }
        }
        System.out.println(res);
    }
}
