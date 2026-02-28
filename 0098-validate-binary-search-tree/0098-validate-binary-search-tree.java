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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        return isVal(root, max, min);       
        
    }

    public boolean isVal(TreeNode root, long max, long min){
        if(root == null) return true;
        //System.out.println(max+" "+min);

        if(root.val >= max || root.val <= min) return false;
        

        return isVal(root.left, root.val, min) && isVal(root.right, max , root.val);

     
    }
}