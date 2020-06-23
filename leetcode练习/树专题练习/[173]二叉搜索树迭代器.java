/*
173. 二叉搜索树迭代器
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

调用 next() 将返回二叉搜索树中的下一个最小的数。

 

示例：



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // 返回 3
iterator.next();    // 返回 7
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 9
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 15
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 20
iterator.hasNext(); // 返回 false
 

提示：

next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
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
 //next() 和 hasNext() 操作的时间复杂度是 O(1),空间复杂度是O(n)
class BSTIterator {
    ArrayList<Integer> list = new ArrayList<>();
    int index = 0;
    public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push (cur);
                cur = cur.left;
            }
            TreeNode tmp = stack.pop();
            list.add (tmp.val);
            cur = tmp.right;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        return list.get(index ++);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        // System.out.println(list.size());
        // System.out.println(index);
        if (index < list.size()) {
            return true;
        }
        return false;
    }
}


//next() 和 hasNext() 操作的时间复杂度是 O(1),平均空间复杂度是O(h)
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = stack.pop();
        int res = tmp.val;
        if (tmp.right != null) {
            tmp = tmp.right;
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
        return res;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}