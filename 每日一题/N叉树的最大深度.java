/*
https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
559. N叉树的最大深度
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。


说明:

树的深度不会超过 1000。
树的节点总不会超过 5000。
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        int max_d=0;      
        if(root==null)   return 0;
        if(root.children.size()==0)   return 1;
        for(int i=0;i<root.children.size();i++)
        max_d=Math.max(max_d,maxDepth(root.children.get(i)));
        return max_d+1;    
    }
}