class Solution {

    static class NodeValue {
        int min, max, sum;
        boolean isBST;

        public NodeValue(int min, int max, int sum, boolean isBST) {
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.isBST = isBST;
        }
    }

    private int maxSum = 0;

    public NodeValue largestBST(TreeNode root) {
        // Base case: null nodes are valid BSTs
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        NodeValue left = largestBST(root.left);
        NodeValue right = largestBST(root.right);

        // A node is a BST if:
        // 1. Both children are BSTs
        // 2. The root value is greater than the maximum in the left subtree
        // 3. The root value is smaller than the minimum in the right subtree
        if (left.isBST && right.isBST && left.max < root.val && root.val < right.min) {
            int currentSum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, currentSum);
            
            return new NodeValue(
                    Math.min(root.val, left.min),
                    Math.max(root.val, right.max),
                    currentSum, 
                    true);
        }

        // If not a valid BST, mark isBST as false. 
        // The sum here doesn't matter for the parent because it won't be used.
        return new NodeValue(0, 0, 0, false);
    }

    public int maxSumBST(TreeNode root) {
        maxSum = 0; // Reset global tracker
        largestBST(root);
        return maxSum;
    }
}