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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sort = new ArrayList<>();
        inorder(sort, root,k);

        return sort.get(sort.size()-1);
    }

    public void inorder(List<Integer> sort, TreeNode root, int k){
        if(root == null) return;

        inorder(sort, root.left, k);
        if(sort.size() == k) return;
        sort.add(root.val);
        inorder(sort, root.right, k);
    }
}