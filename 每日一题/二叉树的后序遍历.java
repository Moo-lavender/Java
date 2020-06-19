/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

 

参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
	//递归解法
	//时间复杂度O(n^2)空间O(n)
    public boolean verifyPostorder(int[] postorder) {
        if (postorder  == null || postorder.length == 0) return true;
        return helper(postorder,0,postorder.length - 1);
    }
    private boolean helper(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int key = postorder[j];
        int index = i;
        while(index < j && postorder[index] < key) {
            index ++;
        }
        int pivot = index;
        while (index < j && postorder[index] > key) {
            index ++;
        }
        if (index != j) return false;
        return helper(postorder,i,pivot-1) && helper(postorder,pivot,j-1);
    }
	
	//单调栈解法
	//时间复杂度O(n)空间O(n)
    public boolean verifyPostorder1(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i --) {
            if (postorder[i] > root) return false;
            while (! stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
			stack.add(postorder[i]);
        }
        return true; 
    }	
}
