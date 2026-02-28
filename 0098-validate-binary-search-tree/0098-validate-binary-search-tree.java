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

        if(root.left != null){
            if(root.left.val >= root.val) return false;
        }
        

        if(root.right != null){
            if(root.val  >= root.right.val) return false;
        }

        boolean left = isVal(root.left, root.val, min);
        boolean right = isVal(root.right, max, root.val);

        if(!left || !right) return false;

        return true;
        
    }

    public boolean isVal(TreeNode root, long max, long min){
        if(root == null) return true;
        //System.out.println(max+" "+min);

        if(root.val >= max) return false;
        if(root.val <= min) return false;

        if(root.left != null){
            if(root.left.val >= root.val) return false;
        }
        

        if(root.right != null){
            if(root.val  >= root.right.val) return false;
        }
        

        if(!isVal(root.left, root.val, min)) return false;

        if(!isVal(root.right, max , root.val)) return false;

        return true;
    }
}