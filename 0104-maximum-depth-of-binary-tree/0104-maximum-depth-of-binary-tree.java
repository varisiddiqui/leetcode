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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int max[] = {0};

        preOrder(root, max, 1);

        return max[0];



    }

    public void preOrder(TreeNode curr, int max[], int level){
        if(curr == null)
        {
            max[0] = Math.max(max[0], level-1);
            return;
        }

        preOrder(curr.left, max, level+1);
        preOrder(curr.right, max, level+1);

    }
}