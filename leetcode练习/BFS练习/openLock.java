/*
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

 

示例 1:

输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
示例 2:

输入: deadends = ["8888"], target = "0009"
输出：1
解释：
把最后一位反向旋转一次即可 "0000" -> "0009"。
示例 3:

输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
输出：-1
解释：
无法旋转到目标数字且不被锁定。
示例 4:

输入: deadends = ["0000"], target = "8888"
输出：-1
 

提示：

死亡列表 deadends 的长度范围为 [1, 500]。
目标数字 target 不会在 deadends 之中。
每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/open-the-lock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/*
思路总结：
首先把题目抽象为图的广度遍历，可以看作是每次变换一步，将符合条件的情况加入到队列中
然后将整体步数＋1，当找到target就表示成功
*/
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(); //使用set存储不能到达的
        for (String s : deadends) {
            dead.add(s);
        }
        HashSet<String> visit = new HashSet<>(); // 保存走过的情况
        Queue<String> queue = new LinkedList<>(); 
        queue.offer("0000"); //加入起始情况
        visit.add("0000");
        int stap = 0; //旋转步数

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                String cur = queue.poll();
                if (dead.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return stap;
                }
				
				//进行四次变换
                for (int j = 0; j < 4; j ++) {
                    String uping = upLock(cur,j);
                    if (!visit.contains(uping)) {
                        queue.add(uping);
                        visit.add(uping);
                    }

                    String downing = downLock(cur,j);
                    if (!visit.contains(downing)) {
                        queue.add(downing);
                        visit.add(downing);
                    }
                } 
            }
            stap ++;
        }
        return -1;

    }
    private String upLock(String str,int j) { // 正向旋转第j位，j+1
        char[] ch = str.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        }else {
            ch[j] += 1;
        }
        return new String(ch);
    }
    private String downLock(String str, int j) {// 反向旋转第j位，j-1
        char[] ch = str.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        }else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}