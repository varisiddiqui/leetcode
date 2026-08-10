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
        //simple apply binary search elimination technique

        if(root == null) return 0;

        int leftDepth = leftDp(root);
        int rightDepth = rightDp(root);

        if(leftDepth == rightDepth) return (int)(Math.pow(2, leftDepth)-1);

        return countNodes(root.left)+countNodes(root.right)+1;
    }


    public int leftDp(TreeNode root){
        if(root == null) return 0;
        int cnt=1;
        while(root.left != null){
            cnt++;
            root = root.left;
        }
        return cnt+1;
    }

    public int rightDp(TreeNode root){
        if(root == null) return 0;
        int cnt = 1;
        while(root.right != null){
            cnt++;
            root = root.right;
        }
        return cnt;
    }


}