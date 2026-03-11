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
    int globalMax=0;
    static class NodeValue {
        int min, max, sum;

        public NodeValue(int max, int min, int sum) {
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }

    public NodeValue largestBST(TreeNode root) {
        if (root == null) {
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        NodeValue left = largestBST(root.left);
        NodeValue right = largestBST(root.right);

        if (left.max < root.val && root.val < right.min) {
            //may be null that's why compare with the root
            int sum = left.sum + right.sum + root.val;
            globalMax = Math.max(sum, globalMax);

            return new NodeValue(
                    Math.max(root.val, right.max),
                    Math.min(root.val, left.min),
                    sum);
        }

        //not valid bst then
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

    }

    public int maxSumBST(TreeNode root) {
        largestBST(root);
        return globalMax;
    }
}