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
class BSTIterator {
    TreeNode root = null;
    Stack<TreeNode> inorder = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.root = root;
        TreeNode temp = root;
        while(temp != null){
            inorder.push(temp);
            temp = temp.left;
        }

    }

    public int next() {
        TreeNode next = inorder.pop();

        TreeNode temp = next.right;
        while(temp != null){
            inorder.push(temp);
            temp = temp.left;
        }

        return next.val;
       
    }

    public boolean hasNext() {
        return !inorder.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */