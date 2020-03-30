/*
0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

 

示例 1：

输入: n = 5, m = 3
输出: 3
示例 2：

输入: n = 10, m = 17
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
        /*时间复杂度O(n^2)
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }
        int index = 0;
        for(int i = 0; i < n-1; i ++) {
            index = (index + m - 1) % (n - i);
            list.remove(index);
        }
        return list.get(0);
        */
    /* 超出时间限制
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        for(int j = 0; j < n - 1; j ++ ) {
            for (int i = 0; i < m - 1; i ++) {
                int tmp = queue.poll();
                queue.add(tmp);
            }
            queue.poll();
        }
        return queue.poll();*/
    }
}