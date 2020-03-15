/*
二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。

示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2
示例 2:

输入: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

输出: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/recover-binary-search-tree
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
class Solution {
    List<TreeNode> list = new LinkedList<>();
    List<Integer> intVal = new LinkedList<>();

    public void recoverTree(TreeNode root) {
        if(root == null) return;
        order(root);
        Collections.sort(intVal);
        for(int i = 0; i < list.size(); i ++){
           list.get(i).val = intVal.get(i);
        }
    }
    public void order (TreeNode root){
        if(root == null) return;
        order(root.left);
        list.add(root);
        intVal.add(root.val);
        order(root.right);
    }
}