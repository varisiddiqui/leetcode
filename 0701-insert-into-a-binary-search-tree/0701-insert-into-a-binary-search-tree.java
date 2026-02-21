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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curr = root;
        TreeNode parent = null;
        if(root == null) return new TreeNode(val);

        while(curr != null){
            parent = curr;
            if(curr.val < val){
                curr = curr.right;
            }
            else curr = curr.left;
        }

        TreeNode insert = new TreeNode(val);


        if(parent.val < val) parent.right = insert;
        else parent.left = insert;

        return root;
        
    }
}