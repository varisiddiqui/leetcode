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
        TreeNode floor = null;
        TreeNode dup = root;
        if(root == null) return new TreeNode(val);
        TreeNode prev=null;

        while (dup != null) {
            if (dup.val < val) {
                floor = dup;
                dup = dup.right;
            } else{
                prev = dup;
                dup = dup.left;
            }
            
                
        }

        if(floor == null) {
            prev.left=new TreeNode(val);
            return root;
        }
        
            TreeNode temp = floor.right;
            TreeNode insert = new TreeNode(val);
            insert.right = temp;
            floor.right = insert;
        

        return root;
    }
}