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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int lh = leftHt(root);
        int rh = rightHt(root);

        if(lh == rh) return (int)Math.pow(2, lh)-1;

        return countNodes(root.left)+countNodes(root.right)+1;                
    }

    public int leftHt(TreeNode root){
        int count=0;
        while(root != null){
            count++;
            root = root.left;
        }
        return count;
    }

    public int rightHt(TreeNode root){
        int count=0;
        while(root != null){
            count++;
            root = root.right;
        }
        return count;
    }



    


}