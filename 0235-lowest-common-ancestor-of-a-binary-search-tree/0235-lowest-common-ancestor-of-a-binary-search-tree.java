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
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        divert(root, p.val, q.val);
        return ans;
    }

    public void divert(TreeNode root, int p, int q){
        if(root == null) return;
        if(ans != null) return;

        if(root.val > p && root.val > q){
            divert(root.left, p, q);
        }

        else if(root.val < p && root.val < q){
            divert(root.right, p, q);
        }

        else{
            ans = root;
        }

        

    }
}