/*501. 二叉搜索树中的众数
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].
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
    int preVal = 0, curTimes = 0, maxTimes = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();
    public int[] findMode(TreeNode root) {
	traversal(root);
	//list转换为int[]
	int size = list.size();
	int[] ans = new int[size];
	for(int i = 0; i < size; i++){
	    ans[i] = list.get(i);
	}
	return ans;
    }
    //二叉搜索树中序遍历是递增顺序
    public void traversal(TreeNode root){
	if(root != null){
	    traversal(root.left);
	    //判断当前值与上一个值的关系, 更新 curTimes 和 preVal
	    if(preVal == root.val){
		curTimes++;
	    }else{
		preVal = root.val;
		curTimes = 1;
	    }
	    //判断当前数量与最大数量的关系, 更新 list 和 maxTimes
	    if(curTimes == maxTimes){
		list.add(root.val);
	    }else if(curTimes > maxTimes){
		list.clear();
		list.add(root.val);
		maxTimes = curTimes;
	    }
	    traversal(root.right);
	}
    }
}