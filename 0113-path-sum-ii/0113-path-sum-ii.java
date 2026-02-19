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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> currL = new ArrayList<>();
        if(root  == null) return ans;

        Sum(root, targetSum, 0, currL, ans);
        return ans;

    }

    public void Sum(TreeNode root, int targetSum, int sum, List<Integer> currL, List<List<Integer>> ans){
        sum += root.val;
        currL.add(root.val);

        if(root.left == null && root.right == null){
            if(sum == targetSum){
                List<Integer> li = new ArrayList<>();
                li.addAll(currL);
                ans.add(li);
            }
        }

        if(root.left != null){
            Sum(root.left, targetSum, sum, currL, ans);
        }
        if(root.right != null){
            Sum(root.right, targetSum, sum, currL, ans);
        }


        currL.remove(currL.size()-1);
    }

}