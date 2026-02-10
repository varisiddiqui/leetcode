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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root.val == p.val) return p;
        if(root.val == q.val) return q;

        TreeNode p1 = lowestCommonAncestor(root.left,  p,  q);
        TreeNode p2 = lowestCommonAncestor(root.right,  p,  q);

        if(p1 == null &&
           p2 == null) return null;
        if(p1 != null && p2 != null) return root;
        
        if(p1 != null) return p1;
          return p2;
        

        
    }
}