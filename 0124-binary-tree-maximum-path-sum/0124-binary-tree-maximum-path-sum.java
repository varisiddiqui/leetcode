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
    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0]=Integer.MIN_VALUE;
        maxP(root, maxValue);
        return maxValue[0];
    }

    public int maxP(TreeNode root, int maxValue[]){
        if(root == null) return 0;
        int left = Math.max(0, maxP(root.left, maxValue));
        int right = Math.max(0, maxP(root.right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left+right+root.val);
        return Math.max(left, right)+root.val;
    }
}