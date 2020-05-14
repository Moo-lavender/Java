/*
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

示例 1:

输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
示例 2:

输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /* 一、回溯算法，超级慢
 执行用时 :4 ms, 在所有 Java 提交中击败了11.12%的用户
内存消耗 :37.9 MB, 在所有 Java 提交中击败了5.55%的用户
*/
class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        back (root);
        int ans = 0;
        for (int tmp : res) {
            ans += tmp;
        }
        return ans;
    }

    private void back (TreeNode root) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(Integer.parseInt(sb.toString()));
            sb.deleteCharAt(sb.length()-1);
            return;
        }

        back(root.left);
        back(root.right);
        sb.deleteCharAt(sb.length()-1);
    }
}
/*
二、思路相同，改为两个变量来保存
执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗 :37.7 MB, 在所有 Java 提交中击败了5.55%的用户
*/
class Solution {
    int res = 0;
    int tmp = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return res;
        }
        tmp = tmp * 10 + root.val;
        if (root.left == null && root.right == null) {  
            res += tmp;
        }
        sumNumbers(root.left);
        sumNumbers(root.right);
        tmp /= 10;
        return res;
    }
}