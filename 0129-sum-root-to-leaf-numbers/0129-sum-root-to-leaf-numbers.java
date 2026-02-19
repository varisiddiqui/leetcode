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
    public int sumNumbers(TreeNode root) {
        int sum[] = new int[1];

        if(root == null) return 0;
        
        leafSum(root, 0, sum);
        return sum[0];
        
       



    }

    public void leafSum(TreeNode root, int currSum, int totSum[]){
        currSum = currSum*10+root.val;

        if(root.left == null && root.right == null){
            totSum[0] += currSum;
        }


        if(root.left != null) leafSum(root.left, currSum, totSum);
        if(root.right != null) leafSum(root.right, currSum, totSum);

        
    }
}