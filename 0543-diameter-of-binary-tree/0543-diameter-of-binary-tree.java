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
    public int diameterOfBinaryTree(TreeNode root) {
        int maxi[]=new int[1];
        
         ht(root, maxi);
         return maxi[0];

       
       
        
    }

    public int ht(TreeNode root, int maxi[]){
        if(root == null)
        return 0;

        int left = ht(root.left, maxi);
        int right = ht(root.right, maxi);
        maxi[0] = Math.max(maxi[0], left+right);
        return Math.max(left, right)+1;
    }
}