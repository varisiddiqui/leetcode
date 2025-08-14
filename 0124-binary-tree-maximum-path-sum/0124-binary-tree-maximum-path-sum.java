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
        if(root == null)
        return 0;
        int max[] = new int[1];
        max[0] = -10000;
        sum(root, max);
        return max[0];
    }

    public int sum(TreeNode root, int max[]){
        if(root == null)
        return 0;

        int left = sum(root.left, max);
        //left only
        if(root.left != null)
        max[0] = Math.max(left, max[0]);

        int right = sum(root.right, max);
        //right only
        if(root.right != null)
        max[0] = Math.max(right, max[0]);

        //node only
        max[0] = Math.max(max[0], root.val);

        //left+node
        max[0] = Math.max(max[0], left+root.val);

        //right+node
        max[0] = Math.max(max[0], right+root.val);

        //overall
        max[0] = Math.max(left+right+root.val, max[0]);

        return root.val + Math.max(0, Math.max(left, right));


    }
}