 /*
 给定一棵二叉树，想象自己站在它的右侧，
 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
 public class RightSideView{
 public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ret.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right !=null) {
                    queue.add(node.right);
                }
            }
        }
        return ret;
    }
 }
