/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;

        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        path(root, path1, p);
        path(root, path2, q);
        int n = Math.min(path1.size(), path2.size());

        TreeNode ans = null;
        for(int i=0; i<n; i++){
            if(path1.get(i).val == path2.get(i).val){
                ans = path1.get(i);
                continue;
            }
            else break;
        }
        return ans;
    }

    public boolean path(TreeNode root, List<TreeNode> path, TreeNode p){
        if(root == null) return false;

        path.add(root);
        if(root.val == p.val){
            return true;
        }

        if(path(root.left, path, p) || path(root.right, path, p)){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
}