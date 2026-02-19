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
        List<Integer> pathSum = new ArrayList<>();

        if(root == null) return 0;
        StringBuilder sum = new StringBuilder();
        leafSum(root, sum, pathSum);
        
        int totSum=0;
        for(int sums: pathSum) totSum += sums;
        return totSum;


    }

    public void leafSum(TreeNode root, StringBuilder sum, List<Integer> pathSum){
        sum.append(String.valueOf(root.val));

        if(root.left == null && root.right == null){
            pathSum.add(Integer.parseInt(sum.toString()));
        }


        if(root.left != null) leafSum(root.left, sum, pathSum);
        if(root.right != null) leafSum(root.right, sum, pathSum);

        sum.deleteCharAt(sum.length()-1);
    }
}