class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        if (root == null) return pre;

        TreeNode curr = root;

        while (curr != null) {

            // Case 1: No left child
            if (curr.left == null) {
                pre.add(curr.val);
                curr = curr.right;
            }

            // Case 2: Has left child
            else {
                TreeNode prev = curr.left;

                // Find rightmost node of left subtree
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                // Create thread
                if (prev.right == null) {
                    pre.add(curr.val);   
                    prev.right = curr;
                    curr = curr.left;
                }

                // Thread exists → remove it
                else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return pre;
    }
}
