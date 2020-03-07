/*给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

示例:

输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
        return new LinkedList<TreeNode>();
        }
        return buildTree(1, n);
    }

    private List<TreeNode> buildTree(int start,int end){
        List<TreeNode> list = new LinkedList<>();
        if (start > end){
            list.add(null);
            return list;
        }
        for(int i = start; i <= end; i ++){
            List<TreeNode> leftList = buildTree(start,i - 1);
            List<TreeNode> rightList = buildTree(i + 1, end);

            for(TreeNode l : leftList){
                for(TreeNode r : rightList){
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = l;
                    tmp.right = r;
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}