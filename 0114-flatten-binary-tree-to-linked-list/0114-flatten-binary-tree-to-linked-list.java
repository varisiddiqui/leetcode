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
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            
            // If there is a left child, we need to process it
            if (curr.left != null) {
                
                TreeNode prev = curr.left;

                // Find the rightmost node of the left subtree
                // Note: We don't need "prev.right != curr" here because 
                // we never create cycles/threads in this version.
                while (prev.right != null) {
                    prev = prev.right;
                }

                // 1. Attach the current right subtree to the end of the left subtree
                prev.right = curr.right;
                
                // 2. Move the entire left subtree to the right side
                curr.right = curr.left;
                
                // 3. Nullify the left pointer to match the linked-list requirement
                curr.left = null;
            }

            // Move to the next node (which is strictly on the right now)
            curr = curr.right;
    }
}
}