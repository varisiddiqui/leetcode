/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return isBal(root);
    }

    public int ht(TreeNode root){
        if(root == null) return 0;

        return Math.max(ht(root.left), ht(root.right))+1;
    }

    public boolean isBal(TreeNode root){
        if(root == null) return true;

        return (Math.abs(ht(root.left)-ht(root.right))<=1) && isBal(root.left) && isBal(root.right);

    }


}