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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;

        String rootD = String.valueOf(root.val);
        StringBuilder str = new StringBuilder(rootD);

        if(root.left == null && root.right==null){
            ans.add(str.toString());
            return ans;
        }

        

        postOrder(root.left, ans, new StringBuilder(str));
        postOrder(root.right, ans, new StringBuilder(str));

        return ans;

    }

    public void postOrder(TreeNode root, List<String> ans, StringBuilder str){
        if(root == null) return;

        String rootD = String.valueOf(root.val);
        rootD = "->"+rootD;
        str.append(rootD);

        if(root.left == null && root.right==null){
            ans.add(str.toString());
            return;
        }

        

       postOrder(root.left, ans, new StringBuilder(str));
        postOrder(root.right, ans, new StringBuilder(str));



    }
}