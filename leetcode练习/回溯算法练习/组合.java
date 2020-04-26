/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
	//用时96ms，时间击败了7.54%，空间击败了51.85%
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) {
            return res;
        }
        back(1,n,k);
        return res;
    }
    private void back(int index,int n,int k) {
        if (tmp.size() == k) {
            res.add (new ArrayList(tmp));
            return;
        }

        for (int i = index; i <= n; i ++) {
            if (tmp.contains(i)) {
                continue;
            }
            tmp.add(i);
            back(i+1,n,k);
            tmp.remove(tmp.size() - 1); 
        }
    }
}
/*
进行优化：
不需要每次都是i <= n，可以通过实际情况进行剪枝
首先对于是否进行for循环，有一个判断： 
如果已经选择的数字的个数 + 可以选择的数字的个数 >= k
成立，才表示有解。
其中：
已经选择的数：tmp.size()
可以选择的数 n-i+1(在进入循环之前数字i还没有被加入到tmp里)
so : tmp.size() + n-i+1 >= k
移项后： i <= tmp.size()+n+1-k

修改后：
执行用时 :4 ms, 在所有 Java 提交中击败了83.46%的用户
内存消耗 :41 MB, 在所有 Java 提交中击败了62.96%的用户
*/