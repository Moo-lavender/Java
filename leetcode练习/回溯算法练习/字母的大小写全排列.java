/*
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

输入: S = "3z4"
输出: ["3z4", "3Z4"]

输入: S = "12345"
输出: ["12345"]
注意：

S 的长度不超过12。
S 仅由数字和字母组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-case-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    List<String> res = new ArrayList<>();
    int tmp = 'A' - 'a';
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() == 0) {
            return res;
        }
        char[] ch = S.toCharArray();
        back(ch,0);
        return res;
    }

    private void back(char[] ch, int index) {
        if (index == ch.length) {
            res.add(new String(ch));
            return;
        }
        if (ch[index] >= '0' && ch[index] <= '9') {
			//如果是数字就继续进行下一个字符的分支
            back(ch,index+1);
            return;
        }
        char t = ch[index];
        back(ch,index + 1); //源字符进行分支
        if (t >= 'a' && t <= 'z') {
           ch[index] += tmp; 
        }else{
            ch[index] -= tmp;
        }
        back(ch,index+1); //修改后继续
        ch[index] = t;
    }

}